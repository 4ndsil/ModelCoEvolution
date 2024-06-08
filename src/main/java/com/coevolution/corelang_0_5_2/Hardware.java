package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Hardware extends Asset {
  public AttemptUseVulnerability attemptUseVulnerability;

  public UseVulnerability useVulnerability;

  public AttemptGainFullAccess attemptGainFullAccess;

  public FullAccess fullAccess;

  public AttemptSupplyChainAttack attemptSupplyChainAttack;

  public SupplyChainAttack supplyChainAttack;

  public SupplyChainAuditing supplyChainAuditing;

  public PhysicalAccess physicalAccess;

  public AttemptHardwareModifications attemptHardwareModifications;

  public SuccessfulHardwareModifications successfulHardwareModifications;

  public HardwareModifications hardwareModifications;

  public HardwareModificationsProtection hardwareModificationsProtection;

  public AttemptUnsafeUserActivity attemptUnsafeUserActivity;

  public UnsafeUserActivity unsafeUserActivity;

  public Deny deny;

  public Read read;

  public Modify modify;

  public BypassHardwareModificationsProtection bypassHardwareModificationsProtection;

  public Set<HardwareVulnerability> vulnerabilities = new HashSet<>();

  public Set<Application> sysExecutedApps = new HashSet<>();

  public Set<PhysicalZone> physicalZones = new HashSet<>();

  public Set<User> users = new HashSet<>();

  public Set<Data> hostedData = new HashSet<>();

  public Hardware(String name, boolean isSupplyChainAuditingEnabled,
      boolean isHardwareModificationsProtectionEnabled) {
    super(name);
    assetClassName = "Hardware";
    AttackStep.allAttackSteps.remove(attemptUseVulnerability);
    attemptUseVulnerability = new AttemptUseVulnerability(name);
    AttackStep.allAttackSteps.remove(useVulnerability);
    useVulnerability = new UseVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptGainFullAccess);
    attemptGainFullAccess = new AttemptGainFullAccess(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(attemptSupplyChainAttack);
    attemptSupplyChainAttack = new AttemptSupplyChainAttack(name);
    AttackStep.allAttackSteps.remove(supplyChainAttack);
    supplyChainAttack = new SupplyChainAttack(name);
    if (supplyChainAuditing != null) {
      AttackStep.allAttackSteps.remove(supplyChainAuditing.disable);
    }
    Defense.allDefenses.remove(supplyChainAuditing);
    supplyChainAuditing = new SupplyChainAuditing(name, isSupplyChainAuditingEnabled);
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
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
    AttackStep.allAttackSteps.remove(bypassHardwareModificationsProtection);
    bypassHardwareModificationsProtection = new BypassHardwareModificationsProtection(name);
  }

  public Hardware(String name) {
    super(name);
    assetClassName = "Hardware";
    AttackStep.allAttackSteps.remove(attemptUseVulnerability);
    attemptUseVulnerability = new AttemptUseVulnerability(name);
    AttackStep.allAttackSteps.remove(useVulnerability);
    useVulnerability = new UseVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptGainFullAccess);
    attemptGainFullAccess = new AttemptGainFullAccess(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(attemptSupplyChainAttack);
    attemptSupplyChainAttack = new AttemptSupplyChainAttack(name);
    AttackStep.allAttackSteps.remove(supplyChainAttack);
    supplyChainAttack = new SupplyChainAttack(name);
    if (supplyChainAuditing != null) {
      AttackStep.allAttackSteps.remove(supplyChainAuditing.disable);
    }
    Defense.allDefenses.remove(supplyChainAuditing);
    supplyChainAuditing = new SupplyChainAuditing(name, false);
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
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
    AttackStep.allAttackSteps.remove(bypassHardwareModificationsProtection);
    bypassHardwareModificationsProtection = new BypassHardwareModificationsProtection(name);
  }

  public Hardware(boolean isSupplyChainAuditingEnabled,
      boolean isHardwareModificationsProtectionEnabled) {
    this("Anonymous", isSupplyChainAuditingEnabled, isHardwareModificationsProtectionEnabled);
  }

  public Hardware() {
    this("Anonymous");
  }

  public void addVulnerabilities(HardwareVulnerability vulnerabilities) {
    this.vulnerabilities.add(vulnerabilities);
    vulnerabilities.hardware = this;
  }

  public void addSysExecutedApps(Application sysExecutedApps) {
    this.sysExecutedApps.add(sysExecutedApps);
    sysExecutedApps.hostHardware = this;
  }

  public void addPhysicalZones(PhysicalZone physicalZones) {
    this.physicalZones.add(physicalZones);
    physicalZones.hardwareSystems.add(this);
  }

  public void addUsers(User users) {
    this.users.add(users);
    users.hardwareSystems.add(this);
  }

  public void addHostedData(Data hostedData) {
    this.hostedData.add(hostedData);
    hostedData.hardware = this;
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("vulnerabilities")) {
      return HardwareVulnerability.class.getName();
    } else if (field.equals("sysExecutedApps")) {
      return Application.class.getName();
    } else if (field.equals("physicalZones")) {
      return PhysicalZone.class.getName();
    } else if (field.equals("users")) {
      return User.class.getName();
    } else if (field.equals("hostedData")) {
      return Data.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("vulnerabilities")) {
      assets.addAll(vulnerabilities);
    } else if (field.equals("sysExecutedApps")) {
      assets.addAll(sysExecutedApps);
    } else if (field.equals("physicalZones")) {
      assets.addAll(physicalZones);
    } else if (field.equals("users")) {
      assets.addAll(users);
    } else if (field.equals("hostedData")) {
      assets.addAll(hostedData);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(vulnerabilities);
    assets.addAll(sysExecutedApps);
    assets.addAll(physicalZones);
    assets.addAll(users);
    assets.addAll(hostedData);
    return assets;
  }

  public class AttemptUseVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptUseVulnerability;

    private Set<AttackStep> _cacheParentAttemptUseVulnerability;

    public AttemptUseVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptUseVulnerability == null) {
        _cacheChildrenAttemptUseVulnerability = new HashSet<>();
        _cacheChildrenAttemptUseVulnerability.add(useVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptUseVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptUseVulnerability == null) {
        _cacheParentAttemptUseVulnerability = new HashSet<>();
        _cacheParentAttemptUseVulnerability.add(hardwareModifications);
        for (Application _0 : sysExecutedApps) {
          _cacheParentAttemptUseVulnerability.add(_0.fullAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptUseVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.attemptUseVulnerability");
    }
  }

  public class UseVulnerability extends AttackStepMax {
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
        _cacheParentUseVulnerability.add(attemptUseVulnerability);
        _cacheParentUseVulnerability.add(hardwareModificationsProtection.disable);
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

  public class AttemptGainFullAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptGainFullAccess;

    private Set<AttackStep> _cacheParentAttemptGainFullAccess;

    public AttemptGainFullAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptGainFullAccess == null) {
        _cacheChildrenAttemptGainFullAccess = new HashSet<>();
        _cacheChildrenAttemptGainFullAccess.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptGainFullAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptGainFullAccess == null) {
        _cacheParentAttemptGainFullAccess = new HashSet<>();
        _cacheParentAttemptGainFullAccess.add(modify);
        _cacheParentAttemptGainFullAccess.add(bypassHardwareModificationsProtection);
      }
      for (AttackStep attackStep : _cacheParentAttemptGainFullAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Hardware.attemptGainFullAccess");
    }
  }

  public class FullAccess extends AttackStepMax {
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
          _cacheChildrenFullAccess.add(_1.attemptAccess);
        }
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
        _cacheParentFullAccess.add(attemptGainFullAccess);
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
        _cacheChildrenAttemptSupplyChainAttack.add(supplyChainAttack);
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

  public class SupplyChainAttack extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSupplyChainAttack;

    private Set<AttackStep> _cacheParentSupplyChainAttack;

    public SupplyChainAttack(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSupplyChainAttack == null) {
        _cacheChildrenSupplyChainAttack = new HashSet<>();
        _cacheChildrenSupplyChainAttack.add(bypassHardwareModificationsProtection);
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
        _cacheParentSupplyChainAttack.add(attemptSupplyChainAttack);
        _cacheParentSupplyChainAttack.add(supplyChainAuditing.disable);
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
          _cacheChildrenSupplyChainAuditing.add(supplyChainAttack);
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
        _cacheParentSuccessfulHardwareModifications.add(hardwareModificationsProtection.disable);
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
        _cacheChildrenHardwareModifications.add(attemptUseVulnerability);
        for (Application _0 : sysExecutedApps) {
          _cacheChildrenHardwareModifications.add(_0.physicalAccessAchieved);
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
          _cacheChildrenHardwareModificationsProtection.add(useVulnerability);
          _cacheChildrenHardwareModificationsProtection.add(successfulHardwareModifications);
          _cacheChildrenHardwareModificationsProtection.add(unsafeUserActivity);
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
        _cacheChildrenAttemptUnsafeUserActivity.add(unsafeUserActivity);
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

  public class UnsafeUserActivity extends AttackStepMax {
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
        _cacheParentUnsafeUserActivity.add(hardwareModificationsProtection.disable);
        _cacheParentUnsafeUserActivity.add(attemptUnsafeUserActivity);
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
        for (HardwareVulnerability _2 : vulnerabilities) {
          _cacheParentDeny.add(_2.deny);
        }
        _cacheParentDeny.add(physicalAccess);
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
        _cacheChildrenModify.add(attemptGainFullAccess);
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
        _cacheChildrenBypassHardwareModificationsProtection.add(attemptGainFullAccess);
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
        _cacheParentBypassHardwareModificationsProtection.add(supplyChainAttack);
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
}
