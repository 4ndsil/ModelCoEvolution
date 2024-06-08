package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class RoutingFirewall extends Application {
  public Set<ConnectionRule> connectionRules = new HashSet<>();

  public Application managerApp = null;

  public RoutingFirewall(String name, boolean isNotPresentEnabled,
      boolean isSupplyChainAuditingEnabled) {
    super(name, isNotPresentEnabled, isSupplyChainAuditingEnabled);
    assetClassName = "RoutingFirewall";
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
  }

  public RoutingFirewall(String name) {
    super(name);
    assetClassName = "RoutingFirewall";
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
  }

  public RoutingFirewall(boolean isNotPresentEnabled, boolean isSupplyChainAuditingEnabled) {
    this("Anonymous", isNotPresentEnabled, isSupplyChainAuditingEnabled);
  }

  public RoutingFirewall() {
    this("Anonymous");
  }

  public void addConnectionRules(ConnectionRule connectionRules) {
    this.connectionRules.add(connectionRules);
    connectionRules.routingFirewalls = this;
  }

  public void addManagerApp(Application managerApp) {
    this.managerApp = managerApp;
    managerApp.managedRoutingFw.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("connectionRules")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("managerApp")) {
      return Application.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("connectionRules")) {
      assets.addAll(connectionRules);
    } else if (field.equals("managerApp")) {
      if (managerApp != null) {
        assets.add(managerApp);
      }
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(connectionRules);
    if (managerApp != null) {
      assets.add(managerApp);
    }
    return assets;
  }

  public class Deny extends Application.Deny {
    private Set<AttackStep> _cacheChildrenDeny;

    public Deny(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDeny == null) {
        _cacheChildrenDeny = new HashSet<>();
        for (ConnectionRule _0 : connectionRules) {
          _cacheChildrenDeny.add(_0.attemptDeny);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDeny) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("RoutingFirewall.deny");
    }
  }

  public class FullAccess extends Application.FullAccess {
    private Set<AttackStep> _cacheChildrenFullAccess;

    public FullAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      super.updateChildren(attackSteps);
      if (_cacheChildrenFullAccess == null) {
        _cacheChildrenFullAccess = new HashSet<>();
        Set<Network> _0 = new HashSet<>();
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        Set<Network> _3 = new HashSet<>();
        Set<Network> _4 = new HashSet<>();
        Set<Network> _5 = new HashSet<>();
        for (ConnectionRule _6 : connectionRules) {
          for (Network _7 : _6.networks) {
            _4.add(_7);
          }
        }
        for (ConnectionRule _8 : connectionRules) {
          for (Network _9 : _8.outNetworks) {
            _5.add(_9);
          }
        }
        _4.addAll(_5);
        for (Network _a : _4) {
          _2.add(_a);
        }
        for (ConnectionRule _b : connectionRules) {
          for (Network _c : _b.inNetworks) {
            _3.add(_c);
          }
        }
        _2.addAll(_3);
        for (Network _d : _2) {
          _0.add(_d);
        }
        for (ConnectionRule _e : connectionRules) {
          for (Network _f : _e.diodeInNetworks) {
            _1.add(_f);
          }
        }
        _0.addAll(_1);
        for (Network _10 : _0) {
          _cacheChildrenFullAccess.add(_10.accessUninspected);
        }
        for (ConnectionRule _11 : connectionRules) {
          for (Application _12 : _11.applications) {
            _cacheChildrenFullAccess.add(_12.networkConnectUninspected);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenFullAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("RoutingFirewall.fullAccess");
    }
  }
}
