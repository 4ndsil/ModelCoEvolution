package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Identity extends IAMObject {
  public LockoutFromCredentials lockoutFromCredentials;

  public MissingUser missingUser;

  public AttemptUnsafeUserActivity attemptUnsafeUserActivity;

  public SuccessfulUnsafeUserActivity successfulUnsafeUserActivity;

  public UnsafeUserActivity unsafeUserActivity;

  public Set<Credentials> credentials = new HashSet<>();

  public Set<Identity> childId = new HashSet<>();

  public Set<Identity> parentId = new HashSet<>();

  public Set<Group> memberOf = new HashSet<>();

  public Set<User> users = new HashSet<>();

  public Identity(String name, boolean isNotPresentEnabled) {
    super(name, isNotPresentEnabled);
    assetClassName = "Identity";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, isNotPresentEnabled);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
    AttackStep.allAttackSteps.remove(lockoutFromCredentials);
    lockoutFromCredentials = new LockoutFromCredentials(name);
    AttackStep.allAttackSteps.remove(lockout);
    lockout = new Lockout(name);
    if (missingUser != null) {
      AttackStep.allAttackSteps.remove(missingUser.disable);
    }
    Defense.allDefenses.remove(missingUser);
    missingUser = new MissingUser(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(successfulUnsafeUserActivity);
    successfulUnsafeUserActivity = new SuccessfulUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
  }

  public Identity(String name) {
    super(name);
    assetClassName = "Identity";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, false);
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
    AttackStep.allAttackSteps.remove(lockoutFromCredentials);
    lockoutFromCredentials = new LockoutFromCredentials(name);
    AttackStep.allAttackSteps.remove(lockout);
    lockout = new Lockout(name);
    if (missingUser != null) {
      AttackStep.allAttackSteps.remove(missingUser.disable);
    }
    Defense.allDefenses.remove(missingUser);
    missingUser = new MissingUser(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(successfulUnsafeUserActivity);
    successfulUnsafeUserActivity = new SuccessfulUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
  }

  public Identity(boolean isNotPresentEnabled) {
    this("Anonymous", isNotPresentEnabled);
  }

  public Identity() {
    this("Anonymous");
  }

  public void addCredentials(Credentials credentials) {
    this.credentials.add(credentials);
    credentials.identities.add(this);
  }

  public void addChildId(Identity childId) {
    this.childId.add(childId);
    childId.parentId.add(this);
  }

  public void addParentId(Identity parentId) {
    this.parentId.add(parentId);
    parentId.childId.add(this);
  }

  public void addMemberOf(Group memberOf) {
    this.memberOf.add(memberOf);
    memberOf.groupIds.add(this);
  }

  public void addUsers(User users) {
    this.users.add(users);
    users.userIds.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("credentials")) {
      return Credentials.class.getName();
    } else if (field.equals("childId")) {
      return Identity.class.getName();
    } else if (field.equals("parentId")) {
      return Identity.class.getName();
    } else if (field.equals("memberOf")) {
      return Group.class.getName();
    } else if (field.equals("users")) {
      return User.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("credentials")) {
      assets.addAll(credentials);
    } else if (field.equals("childId")) {
      assets.addAll(childId);
    } else if (field.equals("parentId")) {
      assets.addAll(parentId);
    } else if (field.equals("memberOf")) {
      assets.addAll(memberOf);
    } else if (field.equals("users")) {
      assets.addAll(users);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(credentials);
    assets.addAll(childId);
    assets.addAll(parentId);
    assets.addAll(memberOf);
    assets.addAll(users);
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
        return "Identity.notPresent";
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
        for (Identity _0 : parentId) {
          _cacheChildrenAssume.add(_0.attemptAssume);
        }
        for (Group _1 : memberOf) {
          _cacheChildrenAssume.add(_1.attemptAssume);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Identity.assume");
    }
  }

  public class LockoutFromCredentials extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenLockoutFromCredentials;

    private Set<AttackStep> _cacheParentLockoutFromCredentials;

    public LockoutFromCredentials(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenLockoutFromCredentials == null) {
        _cacheChildrenLockoutFromCredentials = new HashSet<>();
        if (Identity.this instanceof Identity) {
          _cacheChildrenLockoutFromCredentials.add(((com.coevolution.corelang.Identity) Identity.this).attemptLockout);
        }
      }
      for (AttackStep attackStep : _cacheChildrenLockoutFromCredentials) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentLockoutFromCredentials == null) {
        _cacheParentLockoutFromCredentials = new HashSet<>();
        for (Credentials _0 : credentials) {
          _cacheParentLockoutFromCredentials.add(_0.deny);
        }
      }
      for (AttackStep attackStep : _cacheParentLockoutFromCredentials) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Identity.lockoutFromCredentials");
    }
  }

  public class Lockout extends IAMObject.Lockout {
    private Set<AttackStep> _cacheChildrenLockout;

    public Lockout(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      super.updateChildren(attackSteps);
      if (_cacheChildrenLockout == null) {
        _cacheChildrenLockout = new HashSet<>();
        for (Group _0 : memberOf) {
          _cacheChildrenLockout.add(_0.lockoutFromMembers);
        }
      }
      for (AttackStep attackStep : _cacheChildrenLockout) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Identity.lockout");
    }
  }

  public class MissingUser extends Defense {
    public MissingUser(String name) {
      super(name);
      disable = new Disable(name);
    }

    @Override
    public boolean isEnabled() {
      int count = 1;
      for (User _0 : users) {
        count--;
        break;
      }
      return count == 0;
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenMissingUser;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenMissingUser == null) {
          _cacheChildrenMissingUser = new HashSet<>();
          for (Credentials _1 : credentials) {
            _cacheChildrenMissingUser.add(_1.weakCredentials);
          }
        }
        for (AttackStep attackStep : _cacheChildrenMissingUser) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Identity.missingUser";
      }
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
        for (User _0 : users) {
          _cacheParentAttemptUnsafeUserActivity.add(_0.unsafeUserActivity);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptUnsafeUserActivity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Identity.attemptUnsafeUserActivity");
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
      return ttcHashMap.get("Identity.successfulUnsafeUserActivity");
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
        if (Identity.this instanceof Identity) {
          for (Application _0 : ((com.coevolution.corelang.Identity) Identity.this).execPrivApps) {
            _cacheChildrenUnsafeUserActivity.add(_0.attemptUnsafeUserActivity);
          }
        }
        if (Identity.this instanceof Identity) {
          for (Application _1 : ((com.coevolution.corelang.Identity) Identity.this).highPrivApps) {
            _cacheChildrenUnsafeUserActivity.add(_1.attemptUnsafeUserActivity);
          }
        }
        if (Identity.this instanceof Identity) {
          for (Application _2 : ((com.coevolution.corelang.Identity) Identity.this).lowPrivApps) {
            _cacheChildrenUnsafeUserActivity.add(_2.attemptUnsafeUserActivity);
          }
        }
        if (Identity.this instanceof Identity) {
          for (Privileges _3 : ((com.coevolution.corelang.Identity) Identity.this).subprivileges) {
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
      return ttcHashMap.get("Identity.unsafeUserActivity");
    }
  }
}
