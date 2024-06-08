package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public abstract class IAMObject extends Asset {
  public Disabled disabled;

  public AttemptAssume attemptAssume;

  public SuccessfulAssume successfulAssume;

  public Assume assume;

  public Set<Application> execPrivApps = new HashSet<>();

  public Set<Application> highPrivApps = new HashSet<>();

  public Set<Application> lowPrivApps = new HashSet<>();

  public Set<Data> readPrivData = new HashSet<>();

  public Set<Data> writePrivData = new HashSet<>();

  public Set<Data> deletePrivData = new HashSet<>();

  public Set<IAMObject> managedIAMs = new HashSet<>();

  public Set<IAMObject> managers = new HashSet<>();

  public IAMObject(String name, boolean isDisabledEnabled) {
    super(name);
    assetClassName = "IAMObject";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, isDisabledEnabled);
    AttackStep.allAttackSteps.remove(attemptAssume);
    attemptAssume = new AttemptAssume(name);
    AttackStep.allAttackSteps.remove(successfulAssume);
    successfulAssume = new SuccessfulAssume(name);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public IAMObject(String name) {
    super(name);
    assetClassName = "IAMObject";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, false);
    AttackStep.allAttackSteps.remove(attemptAssume);
    attemptAssume = new AttemptAssume(name);
    AttackStep.allAttackSteps.remove(successfulAssume);
    successfulAssume = new SuccessfulAssume(name);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public IAMObject(boolean isDisabledEnabled) {
    this("Anonymous", isDisabledEnabled);
  }

  public IAMObject() {
    this("Anonymous");
  }

  public void addExecPrivApps(Application execPrivApps) {
    this.execPrivApps.add(execPrivApps);
    execPrivApps.executionPrivIAMs.add(this);
  }

  public void addHighPrivApps(Application highPrivApps) {
    this.highPrivApps.add(highPrivApps);
    highPrivApps.highPrivAppIAMs.add(this);
  }

  public void addLowPrivApps(Application lowPrivApps) {
    this.lowPrivApps.add(lowPrivApps);
    lowPrivApps.lowPrivAppIAMs.add(this);
  }

  public void addReadPrivData(Data readPrivData) {
    this.readPrivData.add(readPrivData);
    readPrivData.readingIAMs.add(this);
  }

  public void addWritePrivData(Data writePrivData) {
    this.writePrivData.add(writePrivData);
    writePrivData.writingIAMs.add(this);
  }

  public void addDeletePrivData(Data deletePrivData) {
    this.deletePrivData.add(deletePrivData);
    deletePrivData.deletingIAMs.add(this);
  }

  public void addManagedIAMs(IAMObject managedIAMs) {
    this.managedIAMs.add(managedIAMs);
    managedIAMs.managers.add(this);
  }

  public void addManagers(IAMObject managers) {
    this.managers.add(managers);
    managers.managedIAMs.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("execPrivApps")) {
      return Application.class.getName();
    } else if (field.equals("highPrivApps")) {
      return Application.class.getName();
    } else if (field.equals("lowPrivApps")) {
      return Application.class.getName();
    } else if (field.equals("readPrivData")) {
      return Data.class.getName();
    } else if (field.equals("writePrivData")) {
      return Data.class.getName();
    } else if (field.equals("deletePrivData")) {
      return Data.class.getName();
    } else if (field.equals("managedIAMs")) {
      return IAMObject.class.getName();
    } else if (field.equals("managers")) {
      return IAMObject.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("execPrivApps")) {
      assets.addAll(execPrivApps);
    } else if (field.equals("highPrivApps")) {
      assets.addAll(highPrivApps);
    } else if (field.equals("lowPrivApps")) {
      assets.addAll(lowPrivApps);
    } else if (field.equals("readPrivData")) {
      assets.addAll(readPrivData);
    } else if (field.equals("writePrivData")) {
      assets.addAll(writePrivData);
    } else if (field.equals("deletePrivData")) {
      assets.addAll(deletePrivData);
    } else if (field.equals("managedIAMs")) {
      assets.addAll(managedIAMs);
    } else if (field.equals("managers")) {
      assets.addAll(managers);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(execPrivApps);
    assets.addAll(highPrivApps);
    assets.addAll(lowPrivApps);
    assets.addAll(readPrivData);
    assets.addAll(writePrivData);
    assets.addAll(deletePrivData);
    assets.addAll(managedIAMs);
    assets.addAll(managers);
    return assets;
  }

  public class Disabled extends Defense {
    public Disabled(String name) {
      this(name, false);
    }

    public Disabled(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenDisabled;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenDisabled == null) {
          _cacheChildrenDisabled = new HashSet<>();
          _cacheChildrenDisabled.add(successfulAssume);
        }
        for (AttackStep attackStep : _cacheChildrenDisabled) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "IAMObject.disabled";
      }
    }
  }

  public class AttemptAssume extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAssume;

    private Set<AttackStep> _cacheParentAttemptAssume;

    public AttemptAssume(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAssume == null) {
        _cacheChildrenAttemptAssume = new HashSet<>();
        _cacheChildrenAttemptAssume.add(successfulAssume);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAssume == null) {
        _cacheParentAttemptAssume = new HashSet<>();
        for (Application _0 : execPrivApps) {
          _cacheParentAttemptAssume.add(_0.fullAccess);
        }
        for (IAMObject _1 : managers) {
          _cacheParentAttemptAssume.add(_1.assume);
        }
        if (IAMObject.this instanceof Identity) {
          for (Identity _2 : ((com.coevolution.corelang_0_5_2.Identity) IAMObject.this).childId) {
            _cacheParentAttemptAssume.add(_2.assume);
          }
        }
        if (IAMObject.this instanceof Group) {
          for (Identity _3 : ((com.coevolution.corelang_0_5_2.Group) IAMObject.this).groupIds) {
            _cacheParentAttemptAssume.add(_3.assume);
          }
        }
        if (IAMObject.this instanceof Privileges) {
          for (Identity _4 : ((com.coevolution.corelang_0_5_2.Privileges) IAMObject.this).privilegeIdentities) {
            _cacheParentAttemptAssume.add(_4.assume);
          }
        }
        if (IAMObject.this instanceof Identity) {
          for (Privileges _5 : ((com.coevolution.corelang_0_5_2.Identity) IAMObject.this).identityPrivileges) {
            _cacheParentAttemptAssume.add(_5.assume);
          }
        }
        if (IAMObject.this instanceof Group) {
          for (Privileges _6 : ((com.coevolution.corelang_0_5_2.Group) IAMObject.this).groupPrivileges) {
            _cacheParentAttemptAssume.add(_6.assume);
          }
        }
        if (IAMObject.this instanceof Group) {
          for (Group _7 : ((com.coevolution.corelang_0_5_2.Group) IAMObject.this).childGroups) {
            _cacheParentAttemptAssume.add(_7.assume);
          }
        }
        if (IAMObject.this instanceof Privileges) {
          for (Group _8 : ((com.coevolution.corelang_0_5_2.Privileges) IAMObject.this).privilegeGroups) {
            _cacheParentAttemptAssume.add(_8.assume);
          }
        }
        if (IAMObject.this instanceof Identity) {
          for (Credentials _9 : ((com.coevolution.corelang_0_5_2.Identity) IAMObject.this).credentials) {
            _cacheParentAttemptAssume.add(_9.use);
          }
        }
        if (IAMObject.this instanceof Identity) {
          for (User _a : ((com.coevolution.corelang_0_5_2.Identity) IAMObject.this).users) {
            _cacheParentAttemptAssume.add(_a.deliverMaliciousRemovableMedia);
          }
        }
        if (IAMObject.this instanceof Identity) {
          for (User _b : ((com.coevolution.corelang_0_5_2.Identity) IAMObject.this).users) {
            _cacheParentAttemptAssume.add(_b.unsafeUserActivity);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAssume) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IAMObject.attemptAssume");
    }
  }

  public class SuccessfulAssume extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulAssume;

    private Set<AttackStep> _cacheParentSuccessfulAssume;

    public SuccessfulAssume(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAssume == null) {
        _cacheChildrenSuccessfulAssume = new HashSet<>();
        _cacheChildrenSuccessfulAssume.add(assume);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulAssume == null) {
        _cacheParentSuccessfulAssume = new HashSet<>();
        _cacheParentSuccessfulAssume.add(disabled.disable);
        _cacheParentSuccessfulAssume.add(attemptAssume);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAssume) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IAMObject.successfulAssume");
    }
  }

  public class Assume extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAssume;

    private Set<AttackStep> _cacheParentAssume;

    public Assume(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAssume == null) {
        _cacheChildrenAssume = new HashSet<>();
        for (Application _0 : execPrivApps) {
          _cacheChildrenAssume.add(_0.authenticate);
        }
        for (Application _1 : highPrivApps) {
          _cacheChildrenAssume.add(_1.authenticate);
        }
        for (Application _2 : lowPrivApps) {
          _cacheChildrenAssume.add(_2.specificAccessAuthenticate);
        }
        for (Data _3 : readPrivData) {
          _cacheChildrenAssume.add(_3.identityAttemptRead);
        }
        for (Data _4 : writePrivData) {
          _cacheChildrenAssume.add(_4.identityAttemptWrite);
        }
        for (Data _5 : deletePrivData) {
          _cacheChildrenAssume.add(_5.identityAttemptDelete);
        }
        for (IAMObject _6 : managedIAMs) {
          _cacheChildrenAssume.add(_6.attemptAssume);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAssume == null) {
        _cacheParentAssume = new HashSet<>();
        _cacheParentAssume.add(successfulAssume);
      }
      for (AttackStep attackStep : _cacheParentAssume) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IAMObject.assume");
    }
  }
}
