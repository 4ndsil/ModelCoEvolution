package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class IDPS extends Application {
  public Effectiveness effectiveness;

  public ProtectionBypassed protectionBypassed;

  public Set<Application> protectedApps = new HashSet<>();

  public IDPS(String name, boolean isDisabledEnabled, boolean isSupplyChainAuditingEnabled,
      boolean isEffectivenessEnabled) {
    super(name, isDisabledEnabled, isSupplyChainAuditingEnabled);
    assetClassName = "IDPS";
    if (effectiveness != null) {
      AttackStep.allAttackSteps.remove(effectiveness.disable);
    }
    Defense.allDefenses.remove(effectiveness);
    effectiveness = new Effectiveness(name, isEffectivenessEnabled);
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, isDisabledEnabled);
    AttackStep.allAttackSteps.remove(protectionBypassed);
    protectionBypassed = new ProtectionBypassed(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
  }

  public IDPS(String name) {
    super(name);
    assetClassName = "IDPS";
    if (effectiveness != null) {
      AttackStep.allAttackSteps.remove(effectiveness.disable);
    }
    Defense.allDefenses.remove(effectiveness);
    effectiveness = new Effectiveness(name, true);
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, false);
    AttackStep.allAttackSteps.remove(protectionBypassed);
    protectionBypassed = new ProtectionBypassed(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
  }

  public IDPS(boolean isDisabledEnabled, boolean isSupplyChainAuditingEnabled,
      boolean isEffectivenessEnabled) {
    this("Anonymous", isDisabledEnabled, isSupplyChainAuditingEnabled, isEffectivenessEnabled);
  }

  public IDPS() {
    this("Anonymous");
  }

  public void addProtectedApps(Application protectedApps) {
    this.protectedApps.add(protectedApps);
    protectedApps.protectorIDPSs.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("protectedApps")) {
      return Application.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("protectedApps")) {
      assets.addAll(protectedApps);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(protectedApps);
    return assets;
  }

  public class Effectiveness extends Defense {
    public Effectiveness(String name) {
      this(name, true);
    }

    public Effectiveness(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenEffectiveness;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenEffectiveness == null) {
          _cacheChildrenEffectiveness = new HashSet<>();
          _cacheChildrenEffectiveness.add(protectionBypassed);
        }
        for (AttackStep attackStep : _cacheChildrenEffectiveness) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "IDPS.effectiveness";
      }
    }
  }

  public class Disabled extends Application.Disabled {
    public Disabled(String name) {
      this(name, false);
    }

    public Disabled(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends Application.Disabled.Disable {
      public Disable(String name) {
        super(name);
      }

      @Override
      public String fullName() {
        return "IDPS.disabled";
      }
    }
  }

  public class ProtectionBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenProtectionBypassed;

    private Set<AttackStep> _cacheParentProtectionBypassed;

    public ProtectionBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenProtectionBypassed == null) {
        _cacheChildrenProtectionBypassed = new HashSet<>();
        for (Application _0 : protectedApps) {
          _cacheChildrenProtectionBypassed.add(_0.useVulnerability);
        }
        for (Application _1 : protectedApps) {
          _cacheChildrenProtectionBypassed.add(_1.unsafeActivityByUser);
        }
      }
      for (AttackStep attackStep : _cacheChildrenProtectionBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentProtectionBypassed == null) {
        _cacheParentProtectionBypassed = new HashSet<>();
        _cacheParentProtectionBypassed.add(effectiveness.disable);
        _cacheParentProtectionBypassed.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheParentProtectionBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IDPS.protectionBypassed");
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
        _cacheChildrenFullAccess.add(protectionBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenFullAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IDPS.fullAccess");
    }
  }
}
