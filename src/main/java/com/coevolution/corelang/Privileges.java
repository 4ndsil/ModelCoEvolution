package com.coevolution.corelang;

import com.coevolution.elements.*;

import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Privileges extends IAMObject {
  public AttemptUnsafeUserActivity attemptUnsafeUserActivity;

  public SuccessfulUnsafeUserActivity successfulUnsafeUserActivity;

  public UnsafeUserActivity unsafeUserActivity;

  public Set<IAMObject> IAMOwners = new HashSet<>();

  public Privileges(String name, boolean isNotPresentEnabled) {
    super(name, isNotPresentEnabled);
    assetClassName = "Privileges";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, isNotPresentEnabled);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(successfulUnsafeUserActivity);
    successfulUnsafeUserActivity = new SuccessfulUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
  }

  public Privileges(String name) {
    super(name);
    assetClassName = "Privileges";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, false);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(successfulUnsafeUserActivity);
    successfulUnsafeUserActivity = new SuccessfulUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
  }

  public Privileges(boolean isNotPresentEnabled) {
    this("Anonymous", isNotPresentEnabled);
  }

  public Privileges() {
    this("Anonymous");
  }

  public void addIAMOwners(IAMObject IAMOwners) {
    this.IAMOwners.add(IAMOwners);
    IAMOwners.subprivileges.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("IAMOwners")) {
      return IAMObject.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("IAMOwners")) {
      assets.addAll(IAMOwners);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(IAMOwners);
    return assets;
  }

  public class NotPresent extends IAMObject.NotPresent {
    public NotPresent(String name) {
      this(name, false);
    }

    public NotPresent(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends IAMObject.NotPresent.Disable {
      private Set<AttackStep> _cacheChildrenNotPresent;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        super.updateChildren(attackSteps);
        if (_cacheChildrenNotPresent == null) {
          _cacheChildrenNotPresent = new HashSet<>();
          _cacheChildrenNotPresent.add(successfulUnsafeUserActivity);
        }
        for (AttackStep attackStep : _cacheChildrenNotPresent) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Privileges.notPresent";
      }
    }
  }

  public class Assume extends IAMObject.Assume {
    private Set<AttackStep> _cacheChildrenAssume;

    public Assume(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      super.updateChildren(attackSteps);
      if (_cacheChildrenAssume == null) {
        _cacheChildrenAssume = new HashSet<>();
        for (IAMObject _0 : IAMOwners) {
          _cacheChildrenAssume.add(_0.attemptAssume);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Privileges.assume");
    }
  }

  public class AttemptUnsafeUserActivity extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptUnsafeUserActivity;

    private Set<AttackStep> _cacheParentAttemptUnsafeUserActivity;

    public AttemptUnsafeUserActivity(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptUnsafeUserActivity == null) {
        _cacheChildrenAttemptUnsafeUserActivity = new HashSet<>();
        _cacheChildrenAttemptUnsafeUserActivity.add(successfulUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptUnsafeUserActivity) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptUnsafeUserActivity == null) {
        _cacheParentAttemptUnsafeUserActivity = new HashSet<>();
        for (IAMObject _0 : IAMOwners) {
          if (_0 instanceof Identity) {
            _cacheParentAttemptUnsafeUserActivity.add(((com.coevolution.corelang.Identity) _0).unsafeUserActivity);
          }
        }
        for (IAMObject _1 : IAMOwners) {
          if (_1 instanceof Privileges) {
            _cacheParentAttemptUnsafeUserActivity.add(((com.coevolution.corelang.Privileges) _1).unsafeUserActivity);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptUnsafeUserActivity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Privileges.attemptUnsafeUserActivity");
    }
  }

  public class SuccessfulUnsafeUserActivity extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulUnsafeUserActivity;

    private Set<AttackStep> _cacheParentSuccessfulUnsafeUserActivity;

    public SuccessfulUnsafeUserActivity(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulUnsafeUserActivity == null) {
        _cacheChildrenSuccessfulUnsafeUserActivity = new HashSet<>();
        _cacheChildrenSuccessfulUnsafeUserActivity.add(unsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulUnsafeUserActivity) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulUnsafeUserActivity == null) {
        _cacheParentSuccessfulUnsafeUserActivity = new HashSet<>();
        _cacheParentSuccessfulUnsafeUserActivity.add(notPresent.disable);
        _cacheParentSuccessfulUnsafeUserActivity.add(attemptUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulUnsafeUserActivity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Privileges.successfulUnsafeUserActivity");
    }
  }

  public class UnsafeUserActivity extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenUnsafeUserActivity;

    private Set<AttackStep> _cacheParentUnsafeUserActivity;

    public UnsafeUserActivity(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUnsafeUserActivity == null) {
        _cacheChildrenUnsafeUserActivity = new HashSet<>();
        if (Privileges.this instanceof Privileges) {
          for (Application _0 : ((com.coevolution.corelang.Privileges) Privileges.this).execPrivApps) {
            _cacheChildrenUnsafeUserActivity.add(_0.attemptUnsafeUserActivity);
          }
        }
        if (Privileges.this instanceof Privileges) {
          for (Application _1 : ((com.coevolution.corelang.Privileges) Privileges.this).highPrivApps) {
            _cacheChildrenUnsafeUserActivity.add(_1.attemptUnsafeUserActivity);
          }
        }
        if (Privileges.this instanceof Privileges) {
          for (Application _2 : ((com.coevolution.corelang.Privileges) Privileges.this).lowPrivApps) {
            _cacheChildrenUnsafeUserActivity.add(_2.attemptUnsafeUserActivity);
          }
        }
        if (Privileges.this instanceof Privileges) {
          for (Privileges _3 : ((com.coevolution.corelang.Privileges) Privileges.this).subprivileges) {
            _cacheChildrenUnsafeUserActivity.add(_3.attemptUnsafeUserActivity);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenUnsafeUserActivity) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUnsafeUserActivity == null) {
        _cacheParentUnsafeUserActivity = new HashSet<>();
        _cacheParentUnsafeUserActivity.add(successfulUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheParentUnsafeUserActivity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Privileges.unsafeUserActivity");
    }
  }
}
