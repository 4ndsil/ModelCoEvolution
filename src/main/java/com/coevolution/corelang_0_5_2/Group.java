package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Group extends IAMObject {
  public Set<Identity> groupIds = new HashSet<>();

  public Set<Group> childGroups = new HashSet<>();

  public Set<Group> parentGroup = new HashSet<>();

  public Set<Privileges> groupPrivileges = new HashSet<>();

  public Group(String name, boolean isDisabledEnabled) {
    super(name, isDisabledEnabled);
    assetClassName = "Group";
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Group(String name) {
    super(name);
    assetClassName = "Group";
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Group(boolean isDisabledEnabled) {
    this("Anonymous", isDisabledEnabled);
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

  public void addGroupPrivileges(Privileges groupPrivileges) {
    this.groupPrivileges.add(groupPrivileges);
    groupPrivileges.privilegeGroups.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("groupIds")) {
      return Identity.class.getName();
    } else if (field.equals("childGroups")) {
      return Group.class.getName();
    } else if (field.equals("parentGroup")) {
      return Group.class.getName();
    } else if (field.equals("groupPrivileges")) {
      return Privileges.class.getName();
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
    } else if (field.equals("groupPrivileges")) {
      assets.addAll(groupPrivileges);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(groupIds);
    assets.addAll(childGroups);
    assets.addAll(parentGroup);
    assets.addAll(groupPrivileges);
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
        for (Privileges _1 : groupPrivileges) {
          _cacheChildrenAssume.add(_1.attemptAssume);
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
}
