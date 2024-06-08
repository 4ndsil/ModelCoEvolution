package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Privileges extends IAMObject {
  public Set<Identity> privilegeIdentities = new HashSet<>();

  public Set<Group> privilegeGroups = new HashSet<>();

  public Privileges(String name, boolean isDisabledEnabled) {
    super(name, isDisabledEnabled);
    assetClassName = "Privileges";
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Privileges(String name) {
    super(name);
    assetClassName = "Privileges";
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Privileges(boolean isDisabledEnabled) {
    this("Anonymous", isDisabledEnabled);
  }

  public Privileges() {
    this("Anonymous");
  }

  public void addPrivilegeIdentities(Identity privilegeIdentities) {
    this.privilegeIdentities.add(privilegeIdentities);
    privilegeIdentities.identityPrivileges.add(this);
  }

  public void addPrivilegeGroups(Group privilegeGroups) {
    this.privilegeGroups.add(privilegeGroups);
    privilegeGroups.groupPrivileges.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("privilegeIdentities")) {
      return Identity.class.getName();
    } else if (field.equals("privilegeGroups")) {
      return Group.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("privilegeIdentities")) {
      assets.addAll(privilegeIdentities);
    } else if (field.equals("privilegeGroups")) {
      assets.addAll(privilegeGroups);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(privilegeIdentities);
    assets.addAll(privilegeGroups);
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
        for (Identity _0 : privilegeIdentities) {
          _cacheChildrenAssume.add(_0.attemptAssume);
        }
        for (Group _1 : privilegeGroups) {
          _cacheChildrenAssume.add(_1.attemptAssume);
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
}
