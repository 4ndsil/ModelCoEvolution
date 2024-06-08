package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Group extends IAMObject {
  public LockoutFromMembers lockoutFromMembers;

  public Set<Identity> groupIds = new HashSet<>();

  public Set<Group> childGroups = new HashSet<>();

  public Set<Group> parentGroup = new HashSet<>();

  public Group(String name, boolean isNotPresentEnabled) {
    super(name, isNotPresentEnabled);
    assetClassName = "Group";
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
    AttackStep.allAttackSteps.remove(lockoutFromMembers);
    lockoutFromMembers = new LockoutFromMembers(name);
  }

  public Group(String name) {
    super(name);
    assetClassName = "Group";
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
    AttackStep.allAttackSteps.remove(lockoutFromMembers);
    lockoutFromMembers = new LockoutFromMembers(name);
  }

  public Group(boolean isNotPresentEnabled) {
    this("Anonymous", isNotPresentEnabled);
  }

  public Group() {
    this("Anonymous");
  }

  public void addGroupIds(Identity groupIds) {
    this.groupIds.add(groupIds);
    groupIds.memberOf.add(this);
  }

  public void addChildGroups(Group childGroups) {
    this.childGroups.add(childGroups);
    childGroups.parentGroup.add(this);
  }

  public void addParentGroup(Group parentGroup) {
    this.parentGroup.add(parentGroup);
    parentGroup.childGroups.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("groupIds")) {
      return Identity.class.getName();
    } else if (field.equals("childGroups")) {
      return Group.class.getName();
    } else if (field.equals("parentGroup")) {
      return Group.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("groupIds")) {
      assets.addAll(groupIds);
    } else if (field.equals("childGroups")) {
      assets.addAll(childGroups);
    } else if (field.equals("parentGroup")) {
      assets.addAll(parentGroup);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(groupIds);
    assets.addAll(childGroups);
    assets.addAll(parentGroup);
    return assets;
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
        for (Group _0 : parentGroup) {
          _cacheChildrenAssume.add(_0.attemptAssume);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAssume) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Group.assume");
    }
  }

  public class LockoutFromMembers extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenLockoutFromMembers;

    private Set<AttackStep> _cacheParentLockoutFromMembers;

    public LockoutFromMembers(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenLockoutFromMembers == null) {
        _cacheChildrenLockoutFromMembers = new HashSet<>();
        if (Group.this instanceof Group) {
          _cacheChildrenLockoutFromMembers.add(((com.coevolution.corelang.Group) Group.this).attemptLockout);
        }
      }
      for (AttackStep attackStep : _cacheChildrenLockoutFromMembers) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentLockoutFromMembers == null) {
        _cacheParentLockoutFromMembers = new HashSet<>();
        for (Identity _0 : groupIds) {
          _cacheParentLockoutFromMembers.add(_0.lockout);
        }
      }
      for (AttackStep attackStep : _cacheParentLockoutFromMembers) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Group.lockoutFromMembers");
    }
  }
}
