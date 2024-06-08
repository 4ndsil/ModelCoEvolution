package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class PhysicalZone extends Asset {
  public GainPhysicalAccess gainPhysicalAccess;

  public Set<Hardware> hardwareSystems = new HashSet<>();

  public Set<Network> networks = new HashSet<>();

  public Set<User> users = new HashSet<>();

  public PhysicalZone(String name) {
    super(name);
    assetClassName = "PhysicalZone";
    AttackStep.allAttackSteps.remove(gainPhysicalAccess);
    gainPhysicalAccess = new GainPhysicalAccess(name);
  }

  public PhysicalZone() {
    this("Anonymous");
  }

  public void addHardwareSystems(Hardware hardwareSystems) {
    this.hardwareSystems.add(hardwareSystems);
    hardwareSystems.physicalZones.add(this);
  }

  public void addNetworks(Network networks) {
    this.networks.add(networks);
    networks.physicalZones.add(this);
  }

  public void addUsers(User users) {
    this.users.add(users);
    users.physicalZones.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("hardwareSystems")) {
      return Hardware.class.getName();
    } else if (field.equals("networks")) {
      return Network.class.getName();
    } else if (field.equals("users")) {
      return User.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("hardwareSystems")) {
      assets.addAll(hardwareSystems);
    } else if (field.equals("networks")) {
      assets.addAll(networks);
    } else if (field.equals("users")) {
      assets.addAll(users);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(hardwareSystems);
    assets.addAll(networks);
    assets.addAll(users);
    return assets;
  }

  public class GainPhysicalAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenGainPhysicalAccess;

    public GainPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenGainPhysicalAccess == null) {
        _cacheChildrenGainPhysicalAccess = new HashSet<>();
        for (Hardware _0 : hardwareSystems) {
          _cacheChildrenGainPhysicalAccess.add(_0.physicalAccess);
        }
        for (Network _1 : networks) {
          _cacheChildrenGainPhysicalAccess.add(_1.physicalAccess);
        }
      }
      for (AttackStep attackStep : _cacheChildrenGainPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("PhysicalZone.gainPhysicalAccess");
    }
  }
}
