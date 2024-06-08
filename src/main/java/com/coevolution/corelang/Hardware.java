package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Hardware extends Asset {
  public AttemptUseVulnerabilityFromPhysicalAccess attemptUseVulnerabilityFromPhysicalAccess;

  public SuccessfulUseVulnerabilityFromPhysicalAccess successfulUseVulnerabilityFromPhysicalAccess;

  public AttemptUseVulnerabilityFromSoftwareFullAccess attemptUseVulnerabilityFromSoftwareFullAccess;

  public UseVulnerability useVulnerability;

  public AttemptSpreadWormThroughRemovableMedia attemptSpreadWormThroughRemovableMedia;

  public SuccessfulSpreadWormThroughRemovableMedia successfulSpreadWormThroughRemovableMedia;

  public SpreadWormThroughRemovableMedia spreadWormThroughRemovableMedia;

  public FullAccess fullAccess;

  public AttemptSupplyChainAttack attemptSupplyChainAttack;

  public SuccessfulSupplyChainAttack successfulSupplyChainAttack;

  public SupplyChainAttack supplyChainAttack;

  public SupplyChainAuditing supplyChainAuditing;

  public BypassSupplyChainAuditing bypassSupplyChainAuditing;

  public SupplyChainAuditingBypassed supplyChainAuditingBypassed;

  public PhysicalAccess physicalAccess;

  public AttemptHardwareModifications attemptHardwareModifications;

  public SuccessfulHardwareModifications successfulHardwareModifications;

  public HardwareModifications hardwareModifications;

  public HardwareModificationsProtection hardwareModificationsProtection;

  public BypassHardwareModificationsProtection bypassHardwareModificationsProtection;

  public HardwareModificationsProtectionBypassed hardwareModificationsProtectionBypassed;

  public AttemptUnsafeUserActivity attemptUnsafeUserActivity;

  public SuccessfulUnsafeUserActivity successfulUnsafeUserActivity;

  public UnsafeUserActivity unsafeUserActivity;

  public Deny deny;

  public Read read;

  public Modify modify;

  public Set<Application> sysExecutedApps = new HashSet<>();

  public Set<PhysicalZone> physicalZones = new HashSet<>();

  public Set<Data> hostedData = new HashSet<>();

  public Set<User> users = new HashSet<>();

  public Set<HardwareVulnerability> vulnerabilities = new HashSet<>();

  public Hardware(String name, boolean isSupplyChainAuditingEnabled,
      boolean isHardwareModificationsProtectionEnabled) {
    super(name);
    assetClassName = "Hardware";
    AttackStep.allAttackSteps.remove(attemptUseVulnerabilityFromPhysicalAccess);
    attemptUseVulnerabilityFromPhysicalAccess = new AttemptUseVulnerabilityFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(successfulUseVulnerabilityFromPhysicalAccess);
    successfulUseVulnerabilityFromPhysicalAccess = new SuccessfulUseVulnerabilityFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(attemptUseVulnerabilityFromSoftwareFullAccess);
    attemptUseVulnerabilityFromSoftwareFullAccess = new AttemptUseVulnerabilityFromSoftwareFullAccess(name);
    AttackStep.allAttackSteps.remove(useVulnerability);
    useVulnerability = new UseVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptSpreadWormThroughRemovableMedia);
    attemptSpreadWormThroughRemovableMedia = new AttemptSpreadWormThroughRemovableMedia(name);
    AttackStep.allAttackSteps.remove(successfulSpreadWormThroughRemovableMedia);
    successfulSpreadWormThroughRemovableMedia = new SuccessfulSpreadWormThroughRemovableMedia(name);
    AttackStep.allAttackSteps.remove(spreadWormThroughRemovableMedia);
    spreadWormThroughRemovableMedia = new SpreadWormThroughRemovableMedia(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(attemptSupplyChainAttack);
    attemptSupplyChainAttack = new AttemptSupplyChainAttack(name);
    AttackStep.allAttackSteps.remove(successfulSupplyChainAttack);
    successfulSupplyChainAttack = new SuccessfulSupplyChainAttack(name);
    AttackStep.allAttackSteps.remove(supplyChainAttack);
    supplyChainAttack = new SupplyChainAttack(name);
    if (supplyChainAuditing != null) {
      AttackStep.allAttackSteps.remove(supplyChainAuditing.disable);
    }
    Defense.allDefenses.remove(supplyChainAuditing);
    supplyChainAuditing = new SupplyChainAuditing(name, isSupplyChainAuditingEnabled);
    AttackStep.allAttackSteps.remove(bypassSupplyChainAuditing);
    bypassSupplyChainAuditing = new BypassSupplyChainAuditing(name);
    AttackStep.allAttackSteps.remove(supplyChainAuditingBypassed);
    supplyChainAuditingBypassed = new SupplyChainAuditingBypassed(name);
    AttackStep.allAttackSteps.remove(physicalAccess);
    physicalAccess = new PhysicalAccess(name);
    AttackStep.allAttackSteps.remove(attemptHardwareModifications);
    attemptHardwareModifications = new AttemptHardwareModifications(name);
    AttackStep.allAttackSteps.remove(successfulHardwareModifications);
    successfulHardwareModifications = new SuccessfulHardwareModifications(name);
    AttackStep.allAttackSteps.remove(hardwareModifications);
    hardwareModifications = new HardwareModifications(name);
    if (hardwareModificationsProtection != null) {
      AttackStep.allAttackSteps.remove(hardwareModificationsProtection.disable);
    }
    Defense.allDefenses.remove(hardwareModificationsProtection);
    hardwareModificationsProtection = new HardwareModificationsProtection(name, isHardwareModificationsProtectionEnabled);
    AttackStep.allAttackSteps.remove(bypassHardwareModificationsProtection);
    bypassHardwareModificationsProtection = new BypassHardwareModificationsProtection(name);
    AttackStep.allAttackSteps.remove(hardwareModificationsProtectionBypassed);
    hardwareModificationsProtectionBypassed = new HardwareModificationsProtectionBypassed(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(successfulUnsafeUserActivity);
    successfulUnsafeUserActivity = new SuccessfulUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
  }

  public Hardware(String name) {
    super(name);
    assetClassName = "Hardware";
    AttackStep.allAttackSteps.remove(attemptUseVulnerabilityFromPhysicalAccess);
    attemptUseVulnerabilityFromPhysicalAccess = new AttemptUseVulnerabilityFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(successfulUseVulnerabilityFromPhysicalAccess);
    successfulUseVulnerabilityFromPhysicalAccess = new SuccessfulUseVulnerabilityFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(attemptUseVulnerabilityFromSoftwareFullAccess);
    attemptUseVulnerabilityFromSoftwareFullAccess = new AttemptUseVulnerabilityFromSoftwareFullAccess(name);
    AttackStep.allAttackSteps.remove(useVulnerability);
    useVulnerability = new UseVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptSpreadWormThroughRemovableMedia);
    attemptSpreadWormThroughRemovableMedia = new AttemptSpreadWormThroughRemovableMedia(name);
    AttackStep.allAttackSteps.remove(successfulSpreadWormThroughRemovableMedia);
    successfulSpreadWormThroughRemovableMedia = new SuccessfulSpreadWormThroughRemovableMedia(name);
    AttackStep.allAttackSteps.remove(spreadWormThroughRemovableMedia);
    spreadWormThroughRemovableMedia = new SpreadWormThroughRemovableMedia(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(attemptSupplyChainAttack);
    attemptSupplyChainAttack = new AttemptSupplyChainAttack(name);
    AttackStep.allAttackSteps.remove(successfulSupplyChainAttack);
    successfulSupplyChainAttack = new SuccessfulSupplyChainAttack(name);
    AttackStep.allAttackSteps.remove(supplyChainAttack);
    supplyChainAttack = new SupplyChainAttack(name);
    if (supplyChainAuditing != null) {
      AttackStep.allAttackSteps.remove(supplyChainAuditing.disable);
    }
    Defense.allDefenses.remove(supplyChainAuditing);
    supplyChainAuditing = new SupplyChainAuditing(name, false);
    AttackStep.allAttackSteps.remove(bypassSupplyChainAuditing);
    bypassSupplyChainAuditing = new BypassSupplyChainAuditing(name);
    AttackStep.allAttackSteps.remove(supplyChainAuditingBypassed);
    supplyChainAuditingBypassed = new SupplyChainAuditingBypassed(name);
    AttackStep.allAttackSteps.remove(physicalAccess);
    physicalAccess = new PhysicalAccess(name);
    AttackStep.allAttackSteps.remove(attemptHardwareModifications);
    attemptHardwareModifications = new AttemptHardwareModifications(name);
    AttackStep.allAttackSteps.remove(successfulHardwareModifications);
    successfulHardwareModifications = new SuccessfulHardwareModifications(name);
    AttackStep.allAttackSteps.remove(hardwareModifications);
    hardwareModifications = new HardwareModifications(name);
    if (hardwareModificationsProtection != null) {
      AttackStep.allAttackSteps.remove(hardwareModificationsProtection.disable);
    }
    Defense.allDefenses.remove(hardwareModificationsProtection);
    hardwareModificationsProtection = new HardwareModificationsProtection(name, false);
    AttackStep.allAttackSteps.remove(bypassHardwareModificationsProtection);
    bypassHardwareModificationsProtection = new BypassHardwareModificationsProtection(name);
    AttackStep.allAttackSteps.remove(hardwareModificationsProtectionBypassed);
    hardwareModificationsProtectionBypassed = new HardwareModificationsProtectionBypassed(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(successfulUnsafeUserActivity);
    successfulUnsafeUserActivity = new SuccessfulUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
  }

  public Hardware(boolean isSupplyChainAuditingEnabled,
      boolean isHardwareModificationsProtectionEnabled) {
    this("Anonymous", isSupplyChainAuditingEnabled, isHardwareModificationsProtectionEnabled);
  }

  public Hardware() {
    this("Anonymous");
  }

  public void addSysExecutedApps(Application sysExecutedApps) {
    this.sysExecutedApps.add(sysExecutedApps);
    sysExecutedApps.hostHardware = this;
  }

  public void addPhysicalZones(PhysicalZone physicalZones) {
    this.physicalZones.add(physicalZones);
    physicalZones.hardwareSystems.add(this);
  }

  public void addHostedData(Data hostedData) {
    this.hostedData.add(hostedData);
    hostedData.hardware = this;
  }

  public void addUsers(User users) {
    this.users.add(users);
    users.hardwareSystems.add(this);
  }

  public void addVulnerabilities(HardwareVulnerability vulnerabilities) {
    this.vulnerabilities.add(vulnerabilities);
    vulnerabilities.hardware = this;
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("sysExecutedApps")) {
      return Application.class.getName();
    } else if (field.equals("physicalZones")) {
      return PhysicalZone.class.getName();
    } else if (field.equals("hostedData")) {
      return Data.class.getName();
    } else if (field.equals("users")) {
      return User.class.getName();
    } else if (field.equals("vulnerabilities")) {
      return HardwareVulnerability.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("sysExecutedApps")) {
      assets.addAll(sysExecutedApps);
    } else if (field.equals("physicalZones")) {
      assets.addAll(physicalZones);
    } else if (field.equals("hostedData")) {
      assets.addAll(hostedData);
    } else if (field.equals("users")) {
      assets.addAll(users);
    } else if (field.equals("vulnerabilities")) {
      assets.addAll(vulnerabilities);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(sysExecutedApps);
    assets.addAll(physicalZones);
    assets.addAll(hostedData);
    assets.addAll(users);
    assets.addAll(vulnerabilities);
    return assets;
  }

  public class AttemptUseVulnerabilityFromPhysicalAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptUseVulnerabilityFromPhysicalAccess;

    private Set<AttackStep> _cacheParentAttemptUseVulnerabilityFromPhysicalAccess;

    public AttemptUseVulnerabilityFromPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptUseVulnerabilityFromPhysicalAccess == null) {
        _cacheChildrenAttemptUseVulnerabilityFromPhysicalAccess = new HashSet<>();
        _cacheChildrenAttemptUseVulnerabilityFromPhysicalAccess.add(successfulUseVulnerabilityFromPhysicalAccess);
        _cacheChildrenAttemptUseVulnerabilityFromPhysicalAccess.add(bypassHardwareModificationsProtection);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptUseVulnerabilityFromPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptUseVulnerabilityFromPhysicalAccess == null) {
        _cacheParentAttemptUseVulnerabilityFromPhysicalAccess = new HashSet<>();
        _cacheParentAttemptUseVulnerabilityFromPhysicalAccess.add(hardwareModifications);
      }
      for (AttackStep attackStep : _cacheParentAttemptUseVulnerabilityFromPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.attemptUseVulnerabilityFromPhysicalAccess");
    }
  }

  public class SuccessfulUseVulnerabilityFromPhysicalAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulUseVulnerabilityFromPhysicalAccess;

    private Set<AttackStep> _cacheParentSuccessfulUseVulnerabilityFromPhysicalAccess;

    public SuccessfulUseVulnerabilityFromPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulUseVulnerabilityFromPhysicalAccess == null) {
        _cacheChildrenSuccessfulUseVulnerabilityFromPhysicalAccess = new HashSet<>();
        _cacheChildrenSuccessfulUseVulnerabilityFromPhysicalAccess.add(useVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulUseVulnerabilityFromPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulUseVulnerabilityFromPhysicalAccess == null) {
        _cacheParentSuccessfulUseVulnerabilityFromPhysicalAccess = new HashSet<>();
        _cacheParentSuccessfulUseVulnerabilityFromPhysicalAccess.add(attemptUseVulnerabilityFromPhysicalAccess);
        _cacheParentSuccessfulUseVulnerabilityFromPhysicalAccess.add(hardwareModificationsProtectionBypassed);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulUseVulnerabilityFromPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.successfulUseVulnerabilityFromPhysicalAccess");
    }
  }

  public class AttemptUseVulnerabilityFromSoftwareFullAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptUseVulnerabilityFromSoftwareFullAccess;

    private Set<AttackStep> _cacheParentAttemptUseVulnerabilityFromSoftwareFullAccess;

    public AttemptUseVulnerabilityFromSoftwareFullAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptUseVulnerabilityFromSoftwareFullAccess == null) {
        _cacheChildrenAttemptUseVulnerabilityFromSoftwareFullAccess = new HashSet<>();
        _cacheChildrenAttemptUseVulnerabilityFromSoftwareFullAccess.add(useVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptUseVulnerabilityFromSoftwareFullAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptUseVulnerabilityFromSoftwareFullAccess == null) {
        _cacheParentAttemptUseVulnerabilityFromSoftwareFullAccess = new HashSet<>();
        for (Application _0 : sysExecutedApps) {
          _cacheParentAttemptUseVulnerabilityFromSoftwareFullAccess.add(_0.fullAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptUseVulnerabilityFromSoftwareFullAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.attemptUseVulnerabilityFromSoftwareFullAccess");
    }
  }

  public class UseVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenUseVulnerability;

    private Set<AttackStep> _cacheParentUseVulnerability;

    public UseVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUseVulnerability == null) {
        _cacheChildrenUseVulnerability = new HashSet<>();
        for (HardwareVulnerability _0 : vulnerabilities) {
          _cacheChildrenUseVulnerability.add(_0.attemptAbuse);
        }
      }
      for (AttackStep attackStep : _cacheChildrenUseVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUseVulnerability == null) {
        _cacheParentUseVulnerability = new HashSet<>();
        _cacheParentUseVulnerability.add(successfulUseVulnerabilityFromPhysicalAccess);
        _cacheParentUseVulnerability.add(attemptUseVulnerabilityFromSoftwareFullAccess);
      }
      for (AttackStep attackStep : _cacheParentUseVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.useVulnerability");
    }
  }

  public class AttemptSpreadWormThroughRemovableMedia extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptSpreadWormThroughRemovableMedia;

    private Set<AttackStep> _cacheParentAttemptSpreadWormThroughRemovableMedia;

    public AttemptSpreadWormThroughRemovableMedia(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptSpreadWormThroughRemovableMedia == null) {
        _cacheChildrenAttemptSpreadWormThroughRemovableMedia = new HashSet<>();
        _cacheChildrenAttemptSpreadWormThroughRemovableMedia.add(successfulSpreadWormThroughRemovableMedia);
        _cacheChildrenAttemptSpreadWormThroughRemovableMedia.add(bypassHardwareModificationsProtection);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptSpreadWormThroughRemovableMedia) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptSpreadWormThroughRemovableMedia == null) {
        _cacheParentAttemptSpreadWormThroughRemovableMedia = new HashSet<>();
        _cacheParentAttemptSpreadWormThroughRemovableMedia.add(fullAccess);
        for (Application _0 : sysExecutedApps) {
          _cacheParentAttemptSpreadWormThroughRemovableMedia.add(_0.fullAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptSpreadWormThroughRemovableMedia) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.attemptSpreadWormThroughRemovableMedia");
    }
  }

  public class SuccessfulSpreadWormThroughRemovableMedia extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulSpreadWormThroughRemovableMedia;

    private Set<AttackStep> _cacheParentSuccessfulSpreadWormThroughRemovableMedia;

    public SuccessfulSpreadWormThroughRemovableMedia(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulSpreadWormThroughRemovableMedia == null) {
        _cacheChildrenSuccessfulSpreadWormThroughRemovableMedia = new HashSet<>();
        _cacheChildrenSuccessfulSpreadWormThroughRemovableMedia.add(spreadWormThroughRemovableMedia);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulSpreadWormThroughRemovableMedia) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulSpreadWormThroughRemovableMedia == null) {
        _cacheParentSuccessfulSpreadWormThroughRemovableMedia = new HashSet<>();
        _cacheParentSuccessfulSpreadWormThroughRemovableMedia.add(attemptSpreadWormThroughRemovableMedia);
        _cacheParentSuccessfulSpreadWormThroughRemovableMedia.add(hardwareModificationsProtectionBypassed);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulSpreadWormThroughRemovableMedia) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.successfulSpreadWormThroughRemovableMedia");
    }
  }

  public class SpreadWormThroughRemovableMedia extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSpreadWormThroughRemovableMedia;

    private Set<AttackStep> _cacheParentSpreadWormThroughRemovableMedia;

    public SpreadWormThroughRemovableMedia(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpreadWormThroughRemovableMedia == null) {
        _cacheChildrenSpreadWormThroughRemovableMedia = new HashSet<>();
        Set<User> _0 = new HashSet<>();
        Set<User> _1 = new HashSet<>();
        for (User _2 : users) {
          _0.add(_2);
        }
        for (PhysicalZone _3 : physicalZones) {
          for (User _4 : _3.users) {
            _1.add(_4);
          }
        }
        _0.addAll(_1);
        for (User _5 : _0) {
          _cacheChildrenSpreadWormThroughRemovableMedia.add(_5.attemptDeliverMaliciousRemovableMedia);
        }
      }
      for (AttackStep attackStep : _cacheChildrenSpreadWormThroughRemovableMedia) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpreadWormThroughRemovableMedia == null) {
        _cacheParentSpreadWormThroughRemovableMedia = new HashSet<>();
        _cacheParentSpreadWormThroughRemovableMedia.add(successfulSpreadWormThroughRemovableMedia);
      }
      for (AttackStep attackStep : _cacheParentSpreadWormThroughRemovableMedia) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.spreadWormThroughRemovableMedia");
    }
  }

  public class FullAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenFullAccess;

    private Set<AttackStep> _cacheParentFullAccess;

    public FullAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenFullAccess == null) {
        _cacheChildrenFullAccess = new HashSet<>();
        for (Application _0 : sysExecutedApps) {
          _cacheChildrenFullAccess.add(_0.fullAccess);
        }
        for (Data _1 : hostedData) {
          _cacheChildrenFullAccess.add(_1.attemptRead);
        }
        for (Data _2 : hostedData) {
          _cacheChildrenFullAccess.add(_2.attemptWrite);
        }
        _cacheChildrenFullAccess.add(deny);
        _cacheChildrenFullAccess.add(attemptSpreadWormThroughRemovableMedia);
      }
      for (AttackStep attackStep : _cacheChildrenFullAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentFullAccess == null) {
        _cacheParentFullAccess = new HashSet<>();
        _cacheParentFullAccess.add(supplyChainAttack);
        _cacheParentFullAccess.add(modify);
      }
      for (AttackStep attackStep : _cacheParentFullAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.fullAccess");
    }
  }

  public class AttemptSupplyChainAttack extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptSupplyChainAttack;

    public AttemptSupplyChainAttack(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptSupplyChainAttack == null) {
        _cacheChildrenAttemptSupplyChainAttack = new HashSet<>();
        _cacheChildrenAttemptSupplyChainAttack.add(successfulSupplyChainAttack);
        _cacheChildrenAttemptSupplyChainAttack.add(bypassSupplyChainAuditing);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptSupplyChainAttack) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.attemptSupplyChainAttack");
    }
  }

  public class SuccessfulSupplyChainAttack extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulSupplyChainAttack;

    private Set<AttackStep> _cacheParentSuccessfulSupplyChainAttack;

    public SuccessfulSupplyChainAttack(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulSupplyChainAttack == null) {
        _cacheChildrenSuccessfulSupplyChainAttack = new HashSet<>();
        _cacheChildrenSuccessfulSupplyChainAttack.add(supplyChainAttack);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulSupplyChainAttack) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulSupplyChainAttack == null) {
        _cacheParentSuccessfulSupplyChainAttack = new HashSet<>();
        _cacheParentSuccessfulSupplyChainAttack.add(attemptSupplyChainAttack);
        _cacheParentSuccessfulSupplyChainAttack.add(supplyChainAuditingBypassed);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulSupplyChainAttack) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.successfulSupplyChainAttack");
    }
  }

  public class SupplyChainAttack extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSupplyChainAttack;

    private Set<AttackStep> _cacheParentSupplyChainAttack;

    public SupplyChainAttack(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSupplyChainAttack == null) {
        _cacheChildrenSupplyChainAttack = new HashSet<>();
        _cacheChildrenSupplyChainAttack.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenSupplyChainAttack) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSupplyChainAttack == null) {
        _cacheParentSupplyChainAttack = new HashSet<>();
        _cacheParentSupplyChainAttack.add(successfulSupplyChainAttack);
      }
      for (AttackStep attackStep : _cacheParentSupplyChainAttack) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.supplyChainAttack");
    }
  }

  public class SupplyChainAuditing extends Defense {
    public SupplyChainAuditing(String name) {
      this(name, false);
    }

    public SupplyChainAuditing(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenSupplyChainAuditing;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenSupplyChainAuditing == null) {
          _cacheChildrenSupplyChainAuditing = new HashSet<>();
          _cacheChildrenSupplyChainAuditing.add(supplyChainAuditingBypassed);
        }
        for (AttackStep attackStep : _cacheChildrenSupplyChainAuditing) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Hardware.supplyChainAuditing";
      }
    }
  }

  public class BypassSupplyChainAuditing extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassSupplyChainAuditing;

    private Set<AttackStep> _cacheParentBypassSupplyChainAuditing;

    public BypassSupplyChainAuditing(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassSupplyChainAuditing == null) {
        _cacheChildrenBypassSupplyChainAuditing = new HashSet<>();
        _cacheChildrenBypassSupplyChainAuditing.add(supplyChainAuditingBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassSupplyChainAuditing) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassSupplyChainAuditing == null) {
        _cacheParentBypassSupplyChainAuditing = new HashSet<>();
        _cacheParentBypassSupplyChainAuditing.add(attemptSupplyChainAttack);
      }
      for (AttackStep attackStep : _cacheParentBypassSupplyChainAuditing) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.bypassSupplyChainAuditing");
    }
  }

  public class SupplyChainAuditingBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSupplyChainAuditingBypassed;

    private Set<AttackStep> _cacheParentSupplyChainAuditingBypassed;

    public SupplyChainAuditingBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSupplyChainAuditingBypassed == null) {
        _cacheChildrenSupplyChainAuditingBypassed = new HashSet<>();
        _cacheChildrenSupplyChainAuditingBypassed.add(successfulSupplyChainAttack);
      }
      for (AttackStep attackStep : _cacheChildrenSupplyChainAuditingBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSupplyChainAuditingBypassed == null) {
        _cacheParentSupplyChainAuditingBypassed = new HashSet<>();
        _cacheParentSupplyChainAuditingBypassed.add(supplyChainAuditing.disable);
        _cacheParentSupplyChainAuditingBypassed.add(bypassSupplyChainAuditing);
      }
      for (AttackStep attackStep : _cacheParentSupplyChainAuditingBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.supplyChainAuditingBypassed");
    }
  }

  public class PhysicalAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenPhysicalAccess;

    private Set<AttackStep> _cacheParentPhysicalAccess;

    public PhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenPhysicalAccess == null) {
        _cacheChildrenPhysicalAccess = new HashSet<>();
        _cacheChildrenPhysicalAccess.add(deny);
        for (Application _0 : sysExecutedApps) {
          _cacheChildrenPhysicalAccess.add(_0.localConnect);
        }
        _cacheChildrenPhysicalAccess.add(attemptHardwareModifications);
      }
      for (AttackStep attackStep : _cacheChildrenPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentPhysicalAccess == null) {
        _cacheParentPhysicalAccess = new HashSet<>();
        for (PhysicalZone _1 : physicalZones) {
          _cacheParentPhysicalAccess.add(_1.gainPhysicalAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.physicalAccess");
    }
  }

  public class AttemptHardwareModifications extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptHardwareModifications;

    private Set<AttackStep> _cacheParentAttemptHardwareModifications;

    public AttemptHardwareModifications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptHardwareModifications == null) {
        _cacheChildrenAttemptHardwareModifications = new HashSet<>();
        _cacheChildrenAttemptHardwareModifications.add(successfulHardwareModifications);
        _cacheChildrenAttemptHardwareModifications.add(bypassHardwareModificationsProtection);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptHardwareModifications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptHardwareModifications == null) {
        _cacheParentAttemptHardwareModifications = new HashSet<>();
        _cacheParentAttemptHardwareModifications.add(physicalAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptHardwareModifications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.attemptHardwareModifications");
    }
  }

  public class SuccessfulHardwareModifications extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulHardwareModifications;

    private Set<AttackStep> _cacheParentSuccessfulHardwareModifications;

    public SuccessfulHardwareModifications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulHardwareModifications == null) {
        _cacheChildrenSuccessfulHardwareModifications = new HashSet<>();
        _cacheChildrenSuccessfulHardwareModifications.add(hardwareModifications);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulHardwareModifications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulHardwareModifications == null) {
        _cacheParentSuccessfulHardwareModifications = new HashSet<>();
        _cacheParentSuccessfulHardwareModifications.add(attemptHardwareModifications);
        _cacheParentSuccessfulHardwareModifications.add(hardwareModificationsProtectionBypassed);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulHardwareModifications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.successfulHardwareModifications");
    }
  }

  public class HardwareModifications extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenHardwareModifications;

    private Set<AttackStep> _cacheParentHardwareModifications;

    public HardwareModifications(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenHardwareModifications == null) {
        _cacheChildrenHardwareModifications = new HashSet<>();
        _cacheChildrenHardwareModifications.add(attemptUseVulnerabilityFromPhysicalAccess);
        for (HardwareVulnerability _0 : vulnerabilities) {
          _cacheChildrenHardwareModifications.add(_0.physicalAccessAchieved);
        }
        for (Application _1 : sysExecutedApps) {
          _cacheChildrenHardwareModifications.add(_1.physicalAccessAchieved);
        }
      }
      for (AttackStep attackStep : _cacheChildrenHardwareModifications) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentHardwareModifications == null) {
        _cacheParentHardwareModifications = new HashSet<>();
        _cacheParentHardwareModifications.add(successfulHardwareModifications);
      }
      for (AttackStep attackStep : _cacheParentHardwareModifications) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.hardwareModifications");
    }
  }

  public class HardwareModificationsProtection extends Defense {
    public HardwareModificationsProtection(String name) {
      this(name, false);
    }

    public HardwareModificationsProtection(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenHardwareModificationsProtection;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenHardwareModificationsProtection == null) {
          _cacheChildrenHardwareModificationsProtection = new HashSet<>();
          _cacheChildrenHardwareModificationsProtection.add(hardwareModificationsProtectionBypassed);
        }
        for (AttackStep attackStep : _cacheChildrenHardwareModificationsProtection) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Hardware.hardwareModificationsProtection";
      }
    }
  }

  public class BypassHardwareModificationsProtection extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassHardwareModificationsProtection;

    private Set<AttackStep> _cacheParentBypassHardwareModificationsProtection;

    public BypassHardwareModificationsProtection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassHardwareModificationsProtection == null) {
        _cacheChildrenBypassHardwareModificationsProtection = new HashSet<>();
        _cacheChildrenBypassHardwareModificationsProtection.add(hardwareModificationsProtectionBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassHardwareModificationsProtection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassHardwareModificationsProtection == null) {
        _cacheParentBypassHardwareModificationsProtection = new HashSet<>();
        _cacheParentBypassHardwareModificationsProtection.add(attemptUseVulnerabilityFromPhysicalAccess);
        _cacheParentBypassHardwareModificationsProtection.add(attemptSpreadWormThroughRemovableMedia);
        _cacheParentBypassHardwareModificationsProtection.add(attemptHardwareModifications);
        _cacheParentBypassHardwareModificationsProtection.add(attemptUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheParentBypassHardwareModificationsProtection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.bypassHardwareModificationsProtection");
    }
  }

  public class HardwareModificationsProtectionBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenHardwareModificationsProtectionBypassed;

    private Set<AttackStep> _cacheParentHardwareModificationsProtectionBypassed;

    public HardwareModificationsProtectionBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenHardwareModificationsProtectionBypassed == null) {
        _cacheChildrenHardwareModificationsProtectionBypassed = new HashSet<>();
        _cacheChildrenHardwareModificationsProtectionBypassed.add(successfulUseVulnerabilityFromPhysicalAccess);
        _cacheChildrenHardwareModificationsProtectionBypassed.add(successfulHardwareModifications);
        _cacheChildrenHardwareModificationsProtectionBypassed.add(successfulSpreadWormThroughRemovableMedia);
        _cacheChildrenHardwareModificationsProtectionBypassed.add(successfulUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheChildrenHardwareModificationsProtectionBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentHardwareModificationsProtectionBypassed == null) {
        _cacheParentHardwareModificationsProtectionBypassed = new HashSet<>();
        _cacheParentHardwareModificationsProtectionBypassed.add(hardwareModificationsProtection.disable);
        _cacheParentHardwareModificationsProtectionBypassed.add(bypassHardwareModificationsProtection);
      }
      for (AttackStep attackStep : _cacheParentHardwareModificationsProtectionBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.hardwareModificationsProtectionBypassed");
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
        _cacheChildrenAttemptUnsafeUserActivity.add(bypassHardwareModificationsProtection);
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
        for (PhysicalZone _0 : physicalZones) {
          for (User _1 : _0.users) {
            _cacheParentAttemptUnsafeUserActivity.add(_1.deliverMaliciousRemovableMedia);
          }
        }
        for (User _2 : users) {
          _cacheParentAttemptUnsafeUserActivity.add(_2.deliverMaliciousRemovableMedia);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptUnsafeUserActivity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.attemptUnsafeUserActivity");
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
        _cacheParentSuccessfulUnsafeUserActivity.add(hardwareModificationsProtectionBypassed);
        _cacheParentSuccessfulUnsafeUserActivity.add(attemptUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulUnsafeUserActivity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.successfulUnsafeUserActivity");
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
        for (Application _0 : sysExecutedApps) {
          _cacheChildrenUnsafeUserActivity.add(_0.attemptUnsafeUserActivity);
        }
        for (Application _1 : sysExecutedApps) {
          _cacheChildrenUnsafeUserActivity.add(_1.physicalAccessAchieved);
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
      return ttcHashMap.get("Hardware.unsafeUserActivity");
    }
  }

  public class Deny extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDeny;

    private Set<AttackStep> _cacheParentDeny;

    public Deny(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDeny == null) {
        _cacheChildrenDeny = new HashSet<>();
        for (Application _0 : sysExecutedApps) {
          _cacheChildrenDeny.add(_0.attemptDeny);
        }
        for (Data _1 : hostedData) {
          _cacheChildrenDeny.add(_1.attemptDeny);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDeny) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDeny == null) {
        _cacheParentDeny = new HashSet<>();
        _cacheParentDeny.add(fullAccess);
        _cacheParentDeny.add(physicalAccess);
        for (HardwareVulnerability _2 : vulnerabilities) {
          _cacheParentDeny.add(_2.deny);
        }
      }
      for (AttackStep attackStep : _cacheParentDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.deny");
    }
  }

  public class Read extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenRead;

    private Set<AttackStep> _cacheParentRead;

    public Read(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenRead == null) {
        _cacheChildrenRead = new HashSet<>();
        for (Application _0 : sysExecutedApps) {
          _cacheChildrenRead.add(_0.attemptRead);
        }
        for (Data _1 : hostedData) {
          _cacheChildrenRead.add(_1.attemptRead);
        }
      }
      for (AttackStep attackStep : _cacheChildrenRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentRead == null) {
        _cacheParentRead = new HashSet<>();
        for (HardwareVulnerability _2 : vulnerabilities) {
          _cacheParentRead.add(_2.read);
        }
      }
      for (AttackStep attackStep : _cacheParentRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.read");
    }
  }

  public class Modify extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenModify;

    private Set<AttackStep> _cacheParentModify;

    public Modify(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenModify == null) {
        _cacheChildrenModify = new HashSet<>();
        _cacheChildrenModify.add(fullAccess);
        for (Application _0 : sysExecutedApps) {
          _cacheChildrenModify.add(_0.attemptModify);
        }
        for (Data _1 : hostedData) {
          _cacheChildrenModify.add(_1.attemptWrite);
        }
      }
      for (AttackStep attackStep : _cacheChildrenModify) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentModify == null) {
        _cacheParentModify = new HashSet<>();
        for (HardwareVulnerability _2 : vulnerabilities) {
          _cacheParentModify.add(_2.modify);
        }
      }
      for (AttackStep attackStep : _cacheParentModify) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.modify");
    }
  }
}
