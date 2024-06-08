package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public abstract class IAMObject extends Information {
  public NotPresent notPresent;

  public AttemptAssume attemptAssume;

  public SuccessfulAssume successfulAssume;

  public Assume assume;

  public AttemptLockout attemptLockout;

  public SuccessfulLockout successfulLockout;

  public Lockout lockout;

  public Set<Application> execPrivApps = new HashSet<>();

  public Set<Application> highPrivApps = new HashSet<>();

  public Set<Application> lowPrivApps = new HashSet<>();

  public Set<Data> readPrivData = new HashSet<>();

  public Set<Data> writePrivData = new HashSet<>();

  public Set<Data> deletePrivData = new HashSet<>();

  public Set<Privileges> subprivileges = new HashSet<>();

  public Set<IAMObject> managedIAMs = new HashSet<>();

  public Set<IAMObject> managers = new HashSet<>();

  public IAMObject(String name, boolean isNotPresentEnabled) {
    super(name);
    assetClassName = "IAMObject";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, isNotPresentEnabled);
    AttackStep.allAttackSteps.remove(attemptAssume);
    attemptAssume = new AttemptAssume(name);
    AttackStep.allAttackSteps.remove(successfulAssume);
    successfulAssume = new SuccessfulAssume(name);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
    AttackStep.allAttackSteps.remove(attemptLockout);
    attemptLockout = new AttemptLockout(name);
    AttackStep.allAttackSteps.remove(successfulLockout);
    successfulLockout = new SuccessfulLockout(name);
    AttackStep.allAttackSteps.remove(lockout);
    lockout = new Lockout(name);
  }

  public IAMObject(String name) {
    super(name);
    assetClassName = "IAMObject";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, false);
    AttackStep.allAttackSteps.remove(attemptAssume);
    attemptAssume = new AttemptAssume(name);
    AttackStep.allAttackSteps.remove(successfulAssume);
    successfulAssume = new SuccessfulAssume(name);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
    AttackStep.allAttackSteps.remove(attemptLockout);
    attemptLockout = new AttemptLockout(name);
    AttackStep.allAttackSteps.remove(successfulLockout);
    successfulLockout = new SuccessfulLockout(name);
    AttackStep.allAttackSteps.remove(lockout);
    lockout = new Lockout(name);
  }

  public IAMObject(boolean isNotPresentEnabled) {
    this("Anonymous", isNotPresentEnabled);
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

  public void addSubprivileges(Privileges subprivileges) {
    this.subprivileges.add(subprivileges);
    subprivileges.IAMOwners.add(this);
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
    } else if (field.equals("subprivileges")) {
      return Privileges.class.getName();
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
    } else if (field.equals("subprivileges")) {
      assets.addAll(subprivileges);
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
    assets.addAll(subprivileges);
    assets.addAll(managedIAMs);
    assets.addAll(managers);
    return assets;
  }

  public class NotPresent extends Defense {
    public NotPresent(String name) {
      this(name, false);
    }

    public NotPresent(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNotPresent;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNotPresent == null) {
          _cacheChildrenNotPresent = new HashSet<>();
          _cacheChildrenNotPresent.add(successfulAssume);
          _cacheChildrenNotPresent.add(successfulLockout);
        }
        for (AttackStep attackStep : _cacheChildrenNotPresent) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "IAMObject.notPresent";
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
        if (IAMObject.this instanceof Privileges) {
          for (IAMObject _2 : ((com.coevolution.corelang.Privileges) IAMObject.this).IAMOwners) {
            _cacheParentAttemptAssume.add(_2.assume);
          }
        }
        _cacheParentAttemptAssume.add(write);
        if (IAMObject.this instanceof Identity) {
          for (Identity _3 : ((com.coevolution.corelang.Identity) IAMObject.this).childId) {
            _cacheParentAttemptAssume.add(_3.assume);
          }
        }
        if (IAMObject.this instanceof Group) {
          for (Identity _4 : ((com.coevolution.corelang.Group) IAMObject.this).groupIds) {
            _cacheParentAttemptAssume.add(_4.assume);
          }
        }
        for (Privileges _5 : subprivileges) {
          _cacheParentAttemptAssume.add(_5.assume);
        }
        if (IAMObject.this instanceof Group) {
          for (Group _6 : ((com.coevolution.corelang.Group) IAMObject.this).childGroups) {
            _cacheParentAttemptAssume.add(_6.assume);
          }
        }
        if (IAMObject.this instanceof Identity) {
          for (Credentials _7 : ((com.coevolution.corelang.Identity) IAMObject.this).credentials) {
            _cacheParentAttemptAssume.add(_7.use);
          }
        }
        if (IAMObject.this instanceof Identity) {
          for (User _8 : ((com.coevolution.corelang.Identity) IAMObject.this).users) {
            _cacheParentAttemptAssume.add(_8.deliverMaliciousRemovableMedia);
          }
        }
        if (IAMObject.this instanceof Identity) {
          for (User _9 : ((com.coevolution.corelang.Identity) IAMObject.this).users) {
            _cacheParentAttemptAssume.add(_9.unsafeUserActivity);
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
        _cacheParentSuccessfulAssume.add(notPresent.disable);
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
          _cacheChildrenAssume.add(_3.authorizedReadFromIAM);
        }
        for (Data _4 : writePrivData) {
          _cacheChildrenAssume.add(_4.authorizedWriteFromIAM);
        }
        for (Data _5 : writePrivData) {
          _cacheChildrenAssume.add(_5.authorizedApplicationRespondConnectFromIAM);
        }
        for (Data _6 : deletePrivData) {
          _cacheChildrenAssume.add(_6.authorizedDeleteFromIAM);
        }
        for (IAMObject _7 : managedIAMs) {
          _cacheChildrenAssume.add(_7.attemptAssume);
        }
        for (Privileges _8 : subprivileges) {
          _cacheChildrenAssume.add(_8.attemptAssume);
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

  public class Deny extends Information.Deny {
    private Set<AttackStep> _cacheChildrenDeny;

    public Deny(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      super.updateChildren(attackSteps);
      if (_cacheChildrenDeny == null) {
        _cacheChildrenDeny = new HashSet<>();
        _cacheChildrenDeny.add(attemptLockout);
      }
      for (AttackStep attackStep : _cacheChildrenDeny) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IAMObject.deny");
    }
  }

  public class Write extends Information.Write {
    private Set<AttackStep> _cacheChildrenWrite;

    public Write(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      super.updateChildren(attackSteps);
      if (_cacheChildrenWrite == null) {
        _cacheChildrenWrite = new HashSet<>();
        _cacheChildrenWrite.add(attemptAssume);
      }
      for (AttackStep attackStep : _cacheChildrenWrite) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IAMObject.write");
    }
  }

  public class AttemptLockout extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptLockout;

    private Set<AttackStep> _cacheParentAttemptLockout;

    public AttemptLockout(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptLockout == null) {
        _cacheChildrenAttemptLockout = new HashSet<>();
        _cacheChildrenAttemptLockout.add(successfulLockout);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptLockout) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptLockout == null) {
        _cacheParentAttemptLockout = new HashSet<>();
        _cacheParentAttemptLockout.add(deny);
        if (IAMObject.this instanceof Identity) {
          _cacheParentAttemptLockout.add(((com.coevolution.corelang.Identity) IAMObject.this).lockoutFromCredentials);
        }
        if (IAMObject.this instanceof Group) {
          _cacheParentAttemptLockout.add(((com.coevolution.corelang.Group) IAMObject.this).lockoutFromMembers);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptLockout) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IAMObject.attemptLockout");
    }
  }

  public class SuccessfulLockout extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulLockout;

    private Set<AttackStep> _cacheParentSuccessfulLockout;

    public SuccessfulLockout(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulLockout == null) {
        _cacheChildrenSuccessfulLockout = new HashSet<>();
        _cacheChildrenSuccessfulLockout.add(lockout);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulLockout) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulLockout == null) {
        _cacheParentSuccessfulLockout = new HashSet<>();
        _cacheParentSuccessfulLockout.add(notPresent.disable);
        _cacheParentSuccessfulLockout.add(attemptLockout);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulLockout) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IAMObject.successfulLockout");
    }
  }

  public class Lockout extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenLockout;

    private Set<AttackStep> _cacheParentLockout;

    public Lockout(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenLockout == null) {
        _cacheChildrenLockout = new HashSet<>();
        for (Application _0 : execPrivApps) {
          _cacheChildrenLockout.add(_0.denyFromLockout);
        }
        for (Data _1 : readPrivData) {
          _cacheChildrenLockout.add(_1.denyFromLockout);
        }
        for (Privileges _2 : subprivileges) {
          _cacheChildrenLockout.add(_2.lockout);
        }
      }
      for (AttackStep attackStep : _cacheChildrenLockout) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentLockout == null) {
        _cacheParentLockout = new HashSet<>();
        _cacheParentLockout.add(successfulLockout);
        if (IAMObject.this instanceof Privileges) {
          for (IAMObject _3 : ((com.coevolution.corelang.Privileges) IAMObject.this).IAMOwners) {
            _cacheParentLockout.add(_3.lockout);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentLockout) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("IAMObject.lockout");
    }
  }
}
