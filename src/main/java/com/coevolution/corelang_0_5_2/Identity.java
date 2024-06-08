package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Identity extends IAMObject {
  public Set<Credentials> credentials = new HashSet<>();

  public Set<User> users = new HashSet<>();

  public Set<Identity> childId = new HashSet<>();

  public Set<Identity> parentId = new HashSet<>();

  public Set<Group> memberOf = new HashSet<>();

  public Set<Privileges> identityPrivileges = new HashSet<>();

  public Identity(String name, boolean isDisabledEnabled) {
    super(name, isDisabledEnabled);
    assetClassName = "Identity";
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Identity(String name) {
    super(name);
    assetClassName = "Identity";
    AttackStep.allAttackSteps.remove(assume);
    assume = new Assume(name);
  }

  public Identity(boolean isDisabledEnabled) {
    this("Anonymous", isDisabledEnabled);
  }

  public Identity() {
    this("Anonymous");
  }

  public void addCredentials(Credentials credentials) {
    this.credentials.add(credentials);
    credentials.identities.add(this);
  }

  public void addUsers(User users) {
    this.users.add(users);
    users.userIds.add(this);
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

  public void addIdentityPrivileges(Privileges identityPrivileges) {
    this.identityPrivileges.add(identityPrivileges);
    identityPrivileges.privilegeIdentities.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("credentials")) {
      return Credentials.class.getName();
    } else if (field.equals("users")) {
      return User.class.getName();
    } else if (field.equals("childId")) {
      return Identity.class.getName();
    } else if (field.equals("parentId")) {
      return Identity.class.getName();
    } else if (field.equals("memberOf")) {
      return Group.class.getName();
    } else if (field.equals("identityPrivileges")) {
      return Privileges.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("credentials")) {
      assets.addAll(credentials);
    } else if (field.equals("users")) {
      assets.addAll(users);
    } else if (field.equals("childId")) {
      assets.addAll(childId);
    } else if (field.equals("parentId")) {
      assets.addAll(parentId);
    } else if (field.equals("memberOf")) {
      assets.addAll(memberOf);
    } else if (field.equals("identityPrivileges")) {
      assets.addAll(identityPrivileges);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(credentials);
    assets.addAll(users);
    assets.addAll(childId);
    assets.addAll(parentId);
    assets.addAll(memberOf);
    assets.addAll(identityPrivileges);
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
        for (Identity _0 : parentId) {
          _cacheChildrenAssume.add(_0.attemptAssume);
        }
        for (Group _1 : memberOf) {
          _cacheChildrenAssume.add(_1.attemptAssume);
        }
        for (Privileges _2 : identityPrivileges) {
          _cacheChildrenAssume.add(_2.attemptAssume);
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
}
