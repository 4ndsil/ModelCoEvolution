package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class ConnectionRule extends Asset {
  public Restricted restricted;

  public PayloadInspection payloadInspection;

  public AttemptReverseReach attemptReverseReach;

  public ReverseReach reverseReach;

  public AttemptAccessNetworks attemptAccessNetworks;

  public AccessNetworks accessNetworks;

  public AttemptConnectToApplications attemptConnectToApplications;

  public ConnectToApplications connectToApplications;

  public ConnectToApplicationsWithoutTriggeringVulnerabilities connectToApplicationsWithoutTriggeringVulnerabilities;

  public AttemptDenialOfService attemptDenialOfService;

  public DenialOfService denialOfService;

  public AttemptAllowWriteDataInTransit attemptAllowWriteDataInTransit;

  public AllowWriteDataInTransit allowWriteDataInTransit;

  public AttemptAllowDenyDataInTransit attemptAllowDenyDataInTransit;

  public AllowDenyDataInTransit allowDenyDataInTransit;

  private Set<Application> _cacheclientApplicationsConnectionRule;

  private Set<Application> _cacheserverApplicationsConnectionRule;

  private Set<Application> _cacheallApplicationsConnectionRule;

  private Set<Application> _cachereverseserverApplicationConnectionsApplication;

  private Set<Application> _cachereverseclientApplicationConnectionsApplication;

  private Set<Network> _cachereverseallowedApplicationConnectionsNetwork;

  private Set<Network> _cachereverseallowedNetworkConnectionsNetwork;

  private Set<Network> _cachereverseallNetConnectionsNetwork;

  public RoutingFirewall routingFirewalls = null;

  public Set<Application> applications = new HashSet<>();

  public Set<Application> inApplications = new HashSet<>();

  public Set<Application> outApplications = new HashSet<>();

  public Set<Network> networks = new HashSet<>();

  public Set<Network> inNetworks = new HashSet<>();

  public Set<Network> outNetworks = new HashSet<>();

  public Set<Network> diodeInNetworks = new HashSet<>();

  public ConnectionRule(String name, boolean isRestrictedEnabled,
      boolean isPayloadInspectionEnabled) {
    super(name);
    assetClassName = "ConnectionRule";
    if (restricted != null) {
      AttackStep.allAttackSteps.remove(restricted.disable);
    }
    Defense.allDefenses.remove(restricted);
    restricted = new Restricted(name, isRestrictedEnabled);
    if (payloadInspection != null) {
      AttackStep.allAttackSteps.remove(payloadInspection.disable);
    }
    Defense.allDefenses.remove(payloadInspection);
    payloadInspection = new PayloadInspection(name, isPayloadInspectionEnabled);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(attemptAccessNetworks);
    attemptAccessNetworks = new AttemptAccessNetworks(name);
    AttackStep.allAttackSteps.remove(accessNetworks);
    accessNetworks = new AccessNetworks(name);
    AttackStep.allAttackSteps.remove(attemptConnectToApplications);
    attemptConnectToApplications = new AttemptConnectToApplications(name);
    AttackStep.allAttackSteps.remove(connectToApplications);
    connectToApplications = new ConnectToApplications(name);
    AttackStep.allAttackSteps.remove(connectToApplicationsWithoutTriggeringVulnerabilities);
    connectToApplicationsWithoutTriggeringVulnerabilities = new ConnectToApplicationsWithoutTriggeringVulnerabilities(name);
    AttackStep.allAttackSteps.remove(attemptDenialOfService);
    attemptDenialOfService = new AttemptDenialOfService(name);
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(attemptAllowWriteDataInTransit);
    attemptAllowWriteDataInTransit = new AttemptAllowWriteDataInTransit(name);
    AttackStep.allAttackSteps.remove(allowWriteDataInTransit);
    allowWriteDataInTransit = new AllowWriteDataInTransit(name);
    AttackStep.allAttackSteps.remove(attemptAllowDenyDataInTransit);
    attemptAllowDenyDataInTransit = new AttemptAllowDenyDataInTransit(name);
    AttackStep.allAttackSteps.remove(allowDenyDataInTransit);
    allowDenyDataInTransit = new AllowDenyDataInTransit(name);
  }

  public ConnectionRule(String name) {
    super(name);
    assetClassName = "ConnectionRule";
    if (restricted != null) {
      AttackStep.allAttackSteps.remove(restricted.disable);
    }
    Defense.allDefenses.remove(restricted);
    restricted = new Restricted(name, false);
    if (payloadInspection != null) {
      AttackStep.allAttackSteps.remove(payloadInspection.disable);
    }
    Defense.allDefenses.remove(payloadInspection);
    payloadInspection = new PayloadInspection(name, false);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(attemptAccessNetworks);
    attemptAccessNetworks = new AttemptAccessNetworks(name);
    AttackStep.allAttackSteps.remove(accessNetworks);
    accessNetworks = new AccessNetworks(name);
    AttackStep.allAttackSteps.remove(attemptConnectToApplications);
    attemptConnectToApplications = new AttemptConnectToApplications(name);
    AttackStep.allAttackSteps.remove(connectToApplications);
    connectToApplications = new ConnectToApplications(name);
    AttackStep.allAttackSteps.remove(connectToApplicationsWithoutTriggeringVulnerabilities);
    connectToApplicationsWithoutTriggeringVulnerabilities = new ConnectToApplicationsWithoutTriggeringVulnerabilities(name);
    AttackStep.allAttackSteps.remove(attemptDenialOfService);
    attemptDenialOfService = new AttemptDenialOfService(name);
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(attemptAllowWriteDataInTransit);
    attemptAllowWriteDataInTransit = new AttemptAllowWriteDataInTransit(name);
    AttackStep.allAttackSteps.remove(allowWriteDataInTransit);
    allowWriteDataInTransit = new AllowWriteDataInTransit(name);
    AttackStep.allAttackSteps.remove(attemptAllowDenyDataInTransit);
    attemptAllowDenyDataInTransit = new AttemptAllowDenyDataInTransit(name);
    AttackStep.allAttackSteps.remove(allowDenyDataInTransit);
    allowDenyDataInTransit = new AllowDenyDataInTransit(name);
  }

  public ConnectionRule(boolean isRestrictedEnabled, boolean isPayloadInspectionEnabled) {
    this("Anonymous", isRestrictedEnabled, isPayloadInspectionEnabled);
  }

  public ConnectionRule() {
    this("Anonymous");
  }

  protected Set<Application> _clientApplicationsConnectionRule() {
    if (_cacheclientApplicationsConnectionRule == null) {
      _cacheclientApplicationsConnectionRule = new HashSet<>();
      Set<Application> _a = new HashSet<>();
      Set<Application> _b = new HashSet<>();
      for (Application _c : applications) {
        _a.add(_c);
      }
      for (Application _d : outApplications) {
        _b.add(_d);
      }
      _a.addAll(_b);
      for (Application _e : _a) {
        _cacheclientApplicationsConnectionRule.add(_e);
      }
    }
    return _cacheclientApplicationsConnectionRule;
  }

  protected Set<Application> _serverApplicationsConnectionRule() {
    if (_cacheserverApplicationsConnectionRule == null) {
      _cacheserverApplicationsConnectionRule = new HashSet<>();
      Set<Application> _f = new HashSet<>();
      Set<Application> _10 = new HashSet<>();
      for (Application _11 : applications) {
        _f.add(_11);
      }
      for (Application _12 : inApplications) {
        _10.add(_12);
      }
      _f.addAll(_10);
      for (Application _13 : _f) {
        _cacheserverApplicationsConnectionRule.add(_13);
      }
    }
    return _cacheserverApplicationsConnectionRule;
  }

  protected Set<Application> _allApplicationsConnectionRule() {
    if (_cacheallApplicationsConnectionRule == null) {
      _cacheallApplicationsConnectionRule = new HashSet<>();
      Set<Application> _14 = new HashSet<>();
      Set<Application> _15 = new HashSet<>();
      Set<Application> _16 = new HashSet<>();
      Set<Application> _17 = new HashSet<>();
      for (Application _18 : applications) {
        _16.add(_18);
      }
      for (Application _19 : inApplications) {
        _17.add(_19);
      }
      _16.addAll(_17);
      for (Application _1a : _16) {
        _14.add(_1a);
      }
      for (Application _1b : outApplications) {
        _15.add(_1b);
      }
      _14.addAll(_15);
      for (Application _1c : _14) {
        _cacheallApplicationsConnectionRule.add(_1c);
      }
    }
    return _cacheallApplicationsConnectionRule;
  }

  protected Set<Application> _reverseserverApplicationConnectionsApplication() {
    if (_cachereverseserverApplicationConnectionsApplication == null) {
      _cachereverseserverApplicationConnectionsApplication = new HashSet<>();
      Set<Application> _1d = new HashSet<>();
      Set<Application> _1e = new HashSet<>();
      for (Application _1f : inApplications) {
        _1d.add(_1f);
      }
      for (Application _20 : applications) {
        _1e.add(_20);
      }
      _1d.addAll(_1e);
      for (Application _21 : _1d) {
        _cachereverseserverApplicationConnectionsApplication.add(_21);
      }
    }
    return _cachereverseserverApplicationConnectionsApplication;
  }

  protected Set<Application> _reverseclientApplicationConnectionsApplication() {
    if (_cachereverseclientApplicationConnectionsApplication == null) {
      _cachereverseclientApplicationConnectionsApplication = new HashSet<>();
      Set<Application> _22 = new HashSet<>();
      Set<Application> _23 = new HashSet<>();
      for (Application _24 : outApplications) {
        _22.add(_24);
      }
      for (Application _25 : applications) {
        _23.add(_25);
      }
      _22.addAll(_23);
      for (Application _26 : _22) {
        _cachereverseclientApplicationConnectionsApplication.add(_26);
      }
    }
    return _cachereverseclientApplicationConnectionsApplication;
  }

  protected Set<Network> _reverseallowedApplicationConnectionsNetwork() {
    if (_cachereverseallowedApplicationConnectionsNetwork == null) {
      _cachereverseallowedApplicationConnectionsNetwork = new HashSet<>();
      Set<Network> _27 = new HashSet<>();
      Set<Network> _28 = new HashSet<>();
      for (Network _29 : outNetworks) {
        _27.add(_29);
      }
      for (Network _2a : networks) {
        _28.add(_2a);
      }
      _27.addAll(_28);
      for (Network _2b : _27) {
        _cachereverseallowedApplicationConnectionsNetwork.add(_2b);
      }
    }
    return _cachereverseallowedApplicationConnectionsNetwork;
  }

  protected Set<Network> _reverseallowedNetworkConnectionsNetwork() {
    if (_cachereverseallowedNetworkConnectionsNetwork == null) {
      _cachereverseallowedNetworkConnectionsNetwork = new HashSet<>();
      Set<Network> _2c = new HashSet<>();
      Set<Network> _2d = new HashSet<>();
      for (Network _2e : outNetworks) {
        _2c.add(_2e);
      }
      for (Network _2f : networks) {
        _2d.add(_2f);
      }
      _2c.addAll(_2d);
      for (Network _30 : _2c) {
        _cachereverseallowedNetworkConnectionsNetwork.add(_30);
      }
    }
    return _cachereverseallowedNetworkConnectionsNetwork;
  }

  protected Set<Network> _reverseallNetConnectionsNetwork() {
    if (_cachereverseallNetConnectionsNetwork == null) {
      _cachereverseallNetConnectionsNetwork = new HashSet<>();
      Set<Network> _31 = new HashSet<>();
      Set<Network> _32 = new HashSet<>();
      for (Network _33 : diodeInNetworks) {
        _31.add(_33);
      }
      Set<Network> _34 = new HashSet<>();
      Set<Network> _35 = new HashSet<>();
      for (Network _36 : outNetworks) {
        _34.add(_36);
      }
      Set<Network> _37 = new HashSet<>();
      Set<Network> _38 = new HashSet<>();
      for (Network _39 : inNetworks) {
        _37.add(_39);
      }
      for (Network _3a : networks) {
        _38.add(_3a);
      }
      _37.addAll(_38);
      for (Network _3b : _37) {
        _35.add(_3b);
      }
      _34.addAll(_35);
      for (Network _3c : _34) {
        _32.add(_3c);
      }
      _31.addAll(_32);
      for (Network _3d : _31) {
        _cachereverseallNetConnectionsNetwork.add(_3d);
      }
    }
    return _cachereverseallNetConnectionsNetwork;
  }

  public void addRoutingFirewalls(RoutingFirewall routingFirewalls) {
    this.routingFirewalls = routingFirewalls;
    routingFirewalls.connectionRules.add(this);
  }

  public void addApplications(Application applications) {
    this.applications.add(applications);
    applications.appConnections.add(this);
  }

  public void addInApplications(Application inApplications) {
    this.inApplications.add(inApplications);
    inApplications.ingoingAppConnections.add(this);
  }

  public void addOutApplications(Application outApplications) {
    this.outApplications.add(outApplications);
    outApplications.outgoingAppConnections.add(this);
  }

  public void addNetworks(Network networks) {
    this.networks.add(networks);
    networks.netConnections.add(this);
  }

  public void addInNetworks(Network inNetworks) {
    this.inNetworks.add(inNetworks);
    inNetworks.ingoingNetConnections.add(this);
  }

  public void addOutNetworks(Network outNetworks) {
    this.outNetworks.add(outNetworks);
    outNetworks.outgoingNetConnections.add(this);
  }

  public void addDiodeInNetworks(Network diodeInNetworks) {
    this.diodeInNetworks.add(diodeInNetworks);
    diodeInNetworks.diodeIngoingNetConnections.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("routingFirewalls")) {
      return RoutingFirewall.class.getName();
    } else if (field.equals("applications")) {
      return Application.class.getName();
    } else if (field.equals("inApplications")) {
      return Application.class.getName();
    } else if (field.equals("outApplications")) {
      return Application.class.getName();
    } else if (field.equals("networks")) {
      return Network.class.getName();
    } else if (field.equals("inNetworks")) {
      return Network.class.getName();
    } else if (field.equals("outNetworks")) {
      return Network.class.getName();
    } else if (field.equals("diodeInNetworks")) {
      return Network.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("routingFirewalls")) {
      if (routingFirewalls != null) {
        assets.add(routingFirewalls);
      }
    } else if (field.equals("applications")) {
      assets.addAll(applications);
    } else if (field.equals("inApplications")) {
      assets.addAll(inApplications);
    } else if (field.equals("outApplications")) {
      assets.addAll(outApplications);
    } else if (field.equals("networks")) {
      assets.addAll(networks);
    } else if (field.equals("inNetworks")) {
      assets.addAll(inNetworks);
    } else if (field.equals("outNetworks")) {
      assets.addAll(outNetworks);
    } else if (field.equals("diodeInNetworks")) {
      assets.addAll(diodeInNetworks);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    if (routingFirewalls != null) {
      assets.add(routingFirewalls);
    }
    assets.addAll(applications);
    assets.addAll(inApplications);
    assets.addAll(outApplications);
    assets.addAll(networks);
    assets.addAll(inNetworks);
    assets.addAll(outNetworks);
    assets.addAll(diodeInNetworks);
    return assets;
  }

  public class Restricted extends Defense {
    public Restricted(String name) {
      this(name, false);
    }

    public Restricted(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenRestricted;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenRestricted == null) {
          _cacheChildrenRestricted = new HashSet<>();
          _cacheChildrenRestricted.add(accessNetworks);
          _cacheChildrenRestricted.add(connectToApplications);
          _cacheChildrenRestricted.add(connectToApplicationsWithoutTriggeringVulnerabilities);
          _cacheChildrenRestricted.add(denialOfService);
          _cacheChildrenRestricted.add(allowWriteDataInTransit);
          _cacheChildrenRestricted.add(allowDenyDataInTransit);
          _cacheChildrenRestricted.add(reverseReach);
        }
        for (AttackStep attackStep : _cacheChildrenRestricted) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "ConnectionRule.restricted";
      }
    }
  }

  public class PayloadInspection extends Defense {
    public PayloadInspection(String name) {
      this(name, false);
    }

    public PayloadInspection(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenPayloadInspection;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenPayloadInspection == null) {
          _cacheChildrenPayloadInspection = new HashSet<>();
          _cacheChildrenPayloadInspection.add(connectToApplications);
          _cacheChildrenPayloadInspection.add(reverseReach);
        }
        for (AttackStep attackStep : _cacheChildrenPayloadInspection) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "ConnectionRule.payloadInspection";
      }
    }
  }

  public class AttemptReverseReach extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptReverseReach;

    private Set<AttackStep> _cacheParentAttemptReverseReach;

    public AttemptReverseReach(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptReverseReach == null) {
        _cacheChildrenAttemptReverseReach = new HashSet<>();
        _cacheChildrenAttemptReverseReach.add(reverseReach);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptReverseReach) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptReverseReach == null) {
        _cacheParentAttemptReverseReach = new HashSet<>();
        for (var _0 : _reverseserverApplicationConnectionsApplication()) {
          _cacheParentAttemptReverseReach.add(_0.reverseReach);
        }
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        for (Network _3 : diodeInNetworks) {
          _1.add(_3);
        }
        Set<Network> _4 = new HashSet<>();
        Set<Network> _5 = new HashSet<>();
        for (Network _6 : inNetworks) {
          _4.add(_6);
        }
        for (Network _7 : networks) {
          _5.add(_7);
        }
        _4.addAll(_5);
        for (Network _8 : _4) {
          _2.add(_8);
        }
        _1.addAll(_2);
        for (Network _9 : _1) {
          _cacheParentAttemptReverseReach.add(_9.reverseReach);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptReverseReach");
    }
  }

  public class ReverseReach extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenReverseReach;

    private Set<AttackStep> _cacheParentReverseReach;

    public ReverseReach(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReverseReach == null) {
        _cacheChildrenReverseReach = new HashSet<>();
        for (var _0 : _clientApplicationsConnectionRule()) {
          _cacheChildrenReverseReach.add(_0.attemptReverseReach);
        }
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        for (Network _3 : networks) {
          _1.add(_3);
        }
        for (Network _4 : outNetworks) {
          _2.add(_4);
        }
        _1.addAll(_2);
        for (Network _5 : _1) {
          _cacheChildrenReverseReach.add(_5.attemptReverseReach);
        }
      }
      for (AttackStep attackStep : _cacheChildrenReverseReach) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReverseReach == null) {
        _cacheParentReverseReach = new HashSet<>();
        _cacheParentReverseReach.add(restricted.disable);
        _cacheParentReverseReach.add(payloadInspection.disable);
        _cacheParentReverseReach.add(attemptReverseReach);
      }
      for (AttackStep attackStep : _cacheParentReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.reverseReach");
    }
  }

  public class AttemptAccessNetworks extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAccessNetworks;

    private Set<AttackStep> _cacheParentAttemptAccessNetworks;

    public AttemptAccessNetworks(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccessNetworks == null) {
        _cacheChildrenAttemptAccessNetworks = new HashSet<>();
        _cacheChildrenAttemptAccessNetworks.add(accessNetworks);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccessNetworks) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccessNetworks == null) {
        _cacheParentAttemptAccessNetworks = new HashSet<>();
        for (var _0 : _reverseclientApplicationConnectionsApplication()) {
          _cacheParentAttemptAccessNetworks.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseallowedNetworkConnectionsNetwork()) {
          _cacheParentAttemptAccessNetworks.add(_1.networkForwarding);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAccessNetworks) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptAccessNetworks");
    }
  }

  public class AccessNetworks extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAccessNetworks;

    private Set<AttackStep> _cacheParentAccessNetworks;

    public AccessNetworks(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessNetworks == null) {
        _cacheChildrenAccessNetworks = new HashSet<>();
        Set<Network> _0 = new HashSet<>();
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        Set<Network> _3 = new HashSet<>();
        for (Network _4 : networks) {
          _2.add(_4);
        }
        for (Network _5 : inNetworks) {
          _3.add(_5);
        }
        _2.addAll(_3);
        for (Network _6 : _2) {
          _0.add(_6);
        }
        for (Network _7 : diodeInNetworks) {
          _1.add(_7);
        }
        _0.addAll(_1);
        for (Network _8 : _0) {
          _cacheChildrenAccessNetworks.add(_8.access);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAccessNetworks) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessNetworks == null) {
        _cacheParentAccessNetworks = new HashSet<>();
        _cacheParentAccessNetworks.add(restricted.disable);
        _cacheParentAccessNetworks.add(attemptAccessNetworks);
      }
      for (AttackStep attackStep : _cacheParentAccessNetworks) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.accessNetworks");
    }
  }

  public class AttemptConnectToApplications extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptConnectToApplications;

    private Set<AttackStep> _cacheParentAttemptConnectToApplications;

    public AttemptConnectToApplications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptConnectToApplications == null) {
        _cacheChildrenAttemptConnectToApplications = new HashSet<>();
        _cacheChildrenAttemptConnectToApplications.add(connectToApplications);
        _cacheChildrenAttemptConnectToApplications.add(connectToApplicationsWithoutTriggeringVulnerabilities);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptConnectToApplications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptConnectToApplications == null) {
        _cacheParentAttemptConnectToApplications = new HashSet<>();
        for (var _0 : _reverseclientApplicationConnectionsApplication()) {
          _cacheParentAttemptConnectToApplications.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseallowedApplicationConnectionsNetwork()) {
          _cacheParentAttemptConnectToApplications.add(_1.successfulAccess);
        }
        for (var _2 : _reverseallowedNetworkConnectionsNetwork()) {
          _cacheParentAttemptConnectToApplications.add(_2.networkForwarding);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptConnectToApplications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptConnectToApplications");
    }
  }

  public class ConnectToApplications extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenConnectToApplications;

    private Set<AttackStep> _cacheParentConnectToApplications;

    public ConnectToApplications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenConnectToApplications == null) {
        _cacheChildrenConnectToApplications = new HashSet<>();
        for (var _0 : _serverApplicationsConnectionRule()) {
          _cacheChildrenConnectToApplications.add(_0.networkConnect);
        }
      }
      for (AttackStep attackStep : _cacheChildrenConnectToApplications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentConnectToApplications == null) {
        _cacheParentConnectToApplications = new HashSet<>();
        _cacheParentConnectToApplications.add(restricted.disable);
        _cacheParentConnectToApplications.add(payloadInspection.disable);
        _cacheParentConnectToApplications.add(attemptConnectToApplications);
      }
      for (AttackStep attackStep : _cacheParentConnectToApplications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.connectToApplications");
    }
  }

  public class ConnectToApplicationsWithoutTriggeringVulnerabilities extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenConnectToApplicationsWithoutTriggeringVulnerabilities;

    private Set<AttackStep> _cacheParentConnectToApplicationsWithoutTriggeringVulnerabilities;

    public ConnectToApplicationsWithoutTriggeringVulnerabilities(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenConnectToApplicationsWithoutTriggeringVulnerabilities == null) {
        _cacheChildrenConnectToApplicationsWithoutTriggeringVulnerabilities = new HashSet<>();
        for (var _0 : _serverApplicationsConnectionRule()) {
          _cacheChildrenConnectToApplicationsWithoutTriggeringVulnerabilities.add(_0.networkConnectWithoutTriggeringVulnerabilities);
        }
      }
      for (AttackStep attackStep : _cacheChildrenConnectToApplicationsWithoutTriggeringVulnerabilities) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentConnectToApplicationsWithoutTriggeringVulnerabilities == null) {
        _cacheParentConnectToApplicationsWithoutTriggeringVulnerabilities = new HashSet<>();
        _cacheParentConnectToApplicationsWithoutTriggeringVulnerabilities.add(restricted.disable);
        _cacheParentConnectToApplicationsWithoutTriggeringVulnerabilities.add(attemptConnectToApplications);
      }
      for (AttackStep attackStep : _cacheParentConnectToApplicationsWithoutTriggeringVulnerabilities) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.connectToApplicationsWithoutTriggeringVulnerabilities");
    }
  }

  public class AttemptDenialOfService extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDenialOfService;

    private Set<AttackStep> _cacheParentAttemptDenialOfService;

    public AttemptDenialOfService(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDenialOfService == null) {
        _cacheChildrenAttemptDenialOfService = new HashSet<>();
        _cacheChildrenAttemptDenialOfService.add(denialOfService);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDenialOfService) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDenialOfService == null) {
        _cacheParentAttemptDenialOfService = new HashSet<>();
        for (var _0 : _reverseallNetConnectionsNetwork()) {
          _cacheParentAttemptDenialOfService.add(_0.denialOfService);
        }
        if (routingFirewalls != null) {
          _cacheParentAttemptDenialOfService.add(routingFirewalls.denialOfService);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDenialOfService) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptDenialOfService");
    }
  }

  public class DenialOfService extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDenialOfService;

    private Set<AttackStep> _cacheParentDenialOfService;

    public DenialOfService(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenialOfService == null) {
        _cacheChildrenDenialOfService = new HashSet<>();
        for (var _0 : _allApplicationsConnectionRule()) {
          _cacheChildrenDenialOfService.add(_0.denyFromNetworkingAsset);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDenialOfService) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenialOfService == null) {
        _cacheParentDenialOfService = new HashSet<>();
        _cacheParentDenialOfService.add(restricted.disable);
        _cacheParentDenialOfService.add(attemptDenialOfService);
      }
      for (AttackStep attackStep : _cacheParentDenialOfService) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.denialOfService");
    }
  }

  public class AttemptAllowWriteDataInTransit extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAllowWriteDataInTransit;

    private Set<AttackStep> _cacheParentAttemptAllowWriteDataInTransit;

    public AttemptAllowWriteDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAllowWriteDataInTransit == null) {
        _cacheChildrenAttemptAllowWriteDataInTransit = new HashSet<>();
        _cacheChildrenAttemptAllowWriteDataInTransit.add(allowWriteDataInTransit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAllowWriteDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAllowWriteDataInTransit == null) {
        _cacheParentAttemptAllowWriteDataInTransit = new HashSet<>();
        for (var _0 : _reverseclientApplicationConnectionsApplication()) {
          _cacheParentAttemptAllowWriteDataInTransit.add(_0.specificAccess);
        }
        for (var _1 : _reverseclientApplicationConnectionsApplication()) {
          _cacheParentAttemptAllowWriteDataInTransit.add(_1.fullAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAllowWriteDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptAllowWriteDataInTransit");
    }
  }

  public class AllowWriteDataInTransit extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAllowWriteDataInTransit;

    private Set<AttackStep> _cacheParentAllowWriteDataInTransit;

    public AllowWriteDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAllowWriteDataInTransit == null) {
        _cacheChildrenAllowWriteDataInTransit = new HashSet<>();
        Set<Network> _0 = new HashSet<>();
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        Set<Network> _3 = new HashSet<>();
        for (Network _4 : networks) {
          _2.add(_4);
        }
        for (Network _5 : inNetworks) {
          _3.add(_5);
        }
        _2.addAll(_3);
        for (Network _6 : _2) {
          _0.add(_6);
        }
        for (Network _7 : diodeInNetworks) {
          _1.add(_7);
        }
        _0.addAll(_1);
        for (Network _8 : _0) {
          for (Data _9 : _8.transitData) {
            _cacheChildrenAllowWriteDataInTransit.add(_9.attemptWriteDataInTransitFromConnectionRule);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenAllowWriteDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAllowWriteDataInTransit == null) {
        _cacheParentAllowWriteDataInTransit = new HashSet<>();
        _cacheParentAllowWriteDataInTransit.add(restricted.disable);
        _cacheParentAllowWriteDataInTransit.add(attemptAllowWriteDataInTransit);
      }
      for (AttackStep attackStep : _cacheParentAllowWriteDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.allowWriteDataInTransit");
    }
  }

  public class AttemptAllowDenyDataInTransit extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAllowDenyDataInTransit;

    private Set<AttackStep> _cacheParentAttemptAllowDenyDataInTransit;

    public AttemptAllowDenyDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAllowDenyDataInTransit == null) {
        _cacheChildrenAttemptAllowDenyDataInTransit = new HashSet<>();
        _cacheChildrenAttemptAllowDenyDataInTransit.add(allowDenyDataInTransit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAllowDenyDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAllowDenyDataInTransit == null) {
        _cacheParentAttemptAllowDenyDataInTransit = new HashSet<>();
        for (var _0 : _reverseclientApplicationConnectionsApplication()) {
          _cacheParentAttemptAllowDenyDataInTransit.add(_0.specificAccess);
        }
        for (var _1 : _reverseclientApplicationConnectionsApplication()) {
          _cacheParentAttemptAllowDenyDataInTransit.add(_1.fullAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAllowDenyDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptAllowDenyDataInTransit");
    }
  }

  public class AllowDenyDataInTransit extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAllowDenyDataInTransit;

    private Set<AttackStep> _cacheParentAllowDenyDataInTransit;

    public AllowDenyDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAllowDenyDataInTransit == null) {
        _cacheChildrenAllowDenyDataInTransit = new HashSet<>();
        Set<Network> _0 = new HashSet<>();
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        Set<Network> _3 = new HashSet<>();
        for (Network _4 : networks) {
          _2.add(_4);
        }
        for (Network _5 : inNetworks) {
          _3.add(_5);
        }
        _2.addAll(_3);
        for (Network _6 : _2) {
          _0.add(_6);
        }
        for (Network _7 : diodeInNetworks) {
          _1.add(_7);
        }
        _0.addAll(_1);
        for (Network _8 : _0) {
          for (Data _9 : _8.transitData) {
            _cacheChildrenAllowDenyDataInTransit.add(_9.attemptDenyDataInTransitFromConnectionRule);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenAllowDenyDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAllowDenyDataInTransit == null) {
        _cacheParentAllowDenyDataInTransit = new HashSet<>();
        _cacheParentAllowDenyDataInTransit.add(restricted.disable);
        _cacheParentAllowDenyDataInTransit.add(attemptAllowDenyDataInTransit);
      }
      for (AttackStep attackStep : _cacheParentAllowDenyDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.allowDenyDataInTransit");
    }
  }
}
