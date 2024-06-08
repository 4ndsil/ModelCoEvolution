package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class IDPS extends Application {
  public Effectiveness effectiveness;

  public BypassEffectiveness bypassEffectiveness;

  public EffectivenessBypassed effectivenessBypassed;

  public Set<Application> protectedApps = new HashSet<>();

  public IDPS(String name, boolean isNotPresentEnabled, boolean isSupplyChainAuditingEnabled,
      boolean isEffectivenessEnabled) {
    super(name, isNotPresentEnabled, isSupplyChainAuditingEnabled);
    assetClassName = "IDPS";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, isNotPresentEnabled);
    if (effectiveness != null) {
      AttackStep.allAttackSteps.remove(effectiveness.disable);
    }
    Defense.allDefenses.remove(effectiveness);
    effectiveness = new Effectiveness(name, isEffectivenessEnabled);
    AttackStep.allAttackSteps.remove(bypassEffectiveness);
    bypassEffectiveness = new BypassEffectiveness(name);
    AttackStep.allAttackSteps.remove(effectivenessBypassed);
    effectivenessBypassed = new EffectivenessBypassed(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
  }

  public IDPS(String name) {
    super(name);
    assetClassName = "IDPS";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, false);
    if (effectiveness != null) {
      AttackStep.allAttackSteps.remove(effectiveness.disable);
    }
    Defense.allDefenses.remove(effectiveness);
    effectiveness = new Effectiveness(name, true);
    AttackStep.allAttackSteps.remove(bypassEffectiveness);
    bypassEffectiveness = new BypassEffectiveness(name);
    AttackStep.allAttackSteps.remove(effectivenessBypassed);
    effectivenessBypassed = new EffectivenessBypassed(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
  }

  public IDPS(boolean isNotPresentEnabled, boolean isSupplyChainAuditingEnabled,
      boolean isEffectivenessEnabled) {
    this("Anonymous", isNotPresentEnabled, isSupplyChainAuditingEnabled, isEffectivenessEnabled);
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

  public class NotPresent extends Application.NotPresent {
    public NotPresent(String name) {
      this(name, false);
    }

    public NotPresent(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends Application.NotPresent.Disable {
      public Disable(String name) {
        super(name);
      }

      @Override
      public String fullName() {
        return "IDPS.notPresent";
      }
    }
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
          _cacheChildrenEffectiveness.add(effectivenessBypassed);
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

  public class BypassEffectiveness extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassEffectiveness;

    private Set<AttackStep> _cacheParentBypassEffectiveness;

    public BypassEffectiveness(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassEffectiveness == null) {
        _cacheChildrenBypassEffectiveness = new HashSet<>();
        _cacheChildrenBypassEffectiveness.add(effectivenessBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassEffectiveness) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassEffectiveness == null) {
        _cacheParentBypassEffectiveness = new HashSet<>();
        for (Application _0 : protectedApps) {
          _cacheParentBypassEffectiveness.add(_0.attemptUseVulnerability);
        }
        for (Application _1 : protectedApps) {
          _cacheParentBypassEffectiveness.add(_1.attemptUnsafeUserActivity);
        }
      }
      for (AttackStep attackStep : _cacheParentBypassEffectiveness) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IDPS.bypassEffectiveness");
    }
  }

  public class EffectivenessBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenEffectivenessBypassed;

    private Set<AttackStep> _cacheParentEffectivenessBypassed;

    public EffectivenessBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenEffectivenessBypassed == null) {
        _cacheChildrenEffectivenessBypassed = new HashSet<>();
        for (Application _0 : protectedApps) {
          _cacheChildrenEffectivenessBypassed.add(_0.successfulUseVulnerability);
        }
        for (Application _1 : protectedApps) {
          _cacheChildrenEffectivenessBypassed.add(_1.successfulUnsafeUserActivity);
        }
      }
      for (AttackStep attackStep : _cacheChildrenEffectivenessBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentEffectivenessBypassed == null) {
        _cacheParentEffectivenessBypassed = new HashSet<>();
        _cacheParentEffectivenessBypassed.add(effectiveness.disable);
        _cacheParentEffectivenessBypassed.add(bypassEffectiveness);
        _cacheParentEffectivenessBypassed.add(fullAccess);
        _cacheParentEffectivenessBypassed.add(deny);
      }
      for (AttackStep attackStep : _cacheParentEffectivenessBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IDPS.effectivenessBypassed");
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
        _cacheChildrenFullAccess.add(effectivenessBypassed);
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

  public class Deny extends Application.Deny {
    private Set<AttackStep> _cacheChildrenDeny;

    public Deny(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      super.updateChildren(attackSteps);
      if (_cacheChildrenDeny == null) {
        _cacheChildrenDeny = new HashSet<>();
        _cacheChildrenDeny.add(effectivenessBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenDeny) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IDPS.deny");
    }
  }
}
