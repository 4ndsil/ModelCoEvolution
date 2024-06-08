package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User extends Asset {
  public NoPasswordReuse noPasswordReuse;

  public NoRemovableMediaUsage noRemovableMediaUsage;

  public SecurityAwareness securityAwareness;

  public BypassSecurityAwareness bypassSecurityAwareness;

  public SecurityAwarenessBypassed securityAwarenessBypassed;

  public OneCredentialCompromised oneCredentialCompromised;

  public PasswordReuseCompromise passwordReuseCompromise;

  public WeakCredentials weakCredentials;

  public AttemptSocialEngineering attemptSocialEngineering;

  public SuccessfulSocialEngineering successfulSocialEngineering;

  public SocialEngineering socialEngineering;

  public AttemptDeliverMaliciousRemovableMedia attemptDeliverMaliciousRemovableMedia;

  public SuccessfulDeliverMaliciousRemovableMedia successfulDeliverMaliciousRemovableMedia;

  public DeliverMaliciousRemovableMedia deliverMaliciousRemovableMedia;

  public CredentialTheft credentialTheft;

  public UnsafeUserActivity unsafeUserActivity;

  public Set<PhysicalZone> physicalZones = new HashSet<>();

  public Set<Hardware> hardwareSystems = new HashSet<>();

  public Set<Identity> userIds = new HashSet<>();

  public User(String name, boolean isNoPasswordReuseEnabled, boolean isNoRemovableMediaUsageEnabled,
      boolean isSecurityAwarenessEnabled) {
    super(name);
    assetClassName = "User";
    if (noPasswordReuse != null) {
      AttackStep.allAttackSteps.remove(noPasswordReuse.disable);
    }
    Defense.allDefenses.remove(noPasswordReuse);
    noPasswordReuse = new NoPasswordReuse(name, isNoPasswordReuseEnabled);
    if (noRemovableMediaUsage != null) {
      AttackStep.allAttackSteps.remove(noRemovableMediaUsage.disable);
    }
    Defense.allDefenses.remove(noRemovableMediaUsage);
    noRemovableMediaUsage = new NoRemovableMediaUsage(name, isNoRemovableMediaUsageEnabled);
    if (securityAwareness != null) {
      AttackStep.allAttackSteps.remove(securityAwareness.disable);
    }
    Defense.allDefenses.remove(securityAwareness);
    securityAwareness = new SecurityAwareness(name, isSecurityAwarenessEnabled);
    AttackStep.allAttackSteps.remove(bypassSecurityAwareness);
    bypassSecurityAwareness = new BypassSecurityAwareness(name);
    AttackStep.allAttackSteps.remove(securityAwarenessBypassed);
    securityAwarenessBypassed = new SecurityAwarenessBypassed(name);
    AttackStep.allAttackSteps.remove(oneCredentialCompromised);
    oneCredentialCompromised = new OneCredentialCompromised(name);
    AttackStep.allAttackSteps.remove(passwordReuseCompromise);
    passwordReuseCompromise = new PasswordReuseCompromise(name);
    AttackStep.allAttackSteps.remove(weakCredentials);
    weakCredentials = new WeakCredentials(name);
    AttackStep.allAttackSteps.remove(attemptSocialEngineering);
    attemptSocialEngineering = new AttemptSocialEngineering(name);
    AttackStep.allAttackSteps.remove(successfulSocialEngineering);
    successfulSocialEngineering = new SuccessfulSocialEngineering(name);
    AttackStep.allAttackSteps.remove(socialEngineering);
    socialEngineering = new SocialEngineering(name);
    AttackStep.allAttackSteps.remove(attemptDeliverMaliciousRemovableMedia);
    attemptDeliverMaliciousRemovableMedia = new AttemptDeliverMaliciousRemovableMedia(name);
    AttackStep.allAttackSteps.remove(successfulDeliverMaliciousRemovableMedia);
    successfulDeliverMaliciousRemovableMedia = new SuccessfulDeliverMaliciousRemovableMedia(name);
    AttackStep.allAttackSteps.remove(deliverMaliciousRemovableMedia);
    deliverMaliciousRemovableMedia = new DeliverMaliciousRemovableMedia(name);
    AttackStep.allAttackSteps.remove(credentialTheft);
    credentialTheft = new CredentialTheft(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
  }

  public User(String name) {
    super(name);
    assetClassName = "User";
    if (noPasswordReuse != null) {
      AttackStep.allAttackSteps.remove(noPasswordReuse.disable);
    }
    Defense.allDefenses.remove(noPasswordReuse);
    noPasswordReuse = new NoPasswordReuse(name, true);
    if (noRemovableMediaUsage != null) {
      AttackStep.allAttackSteps.remove(noRemovableMediaUsage.disable);
    }
    Defense.allDefenses.remove(noRemovableMediaUsage);
    noRemovableMediaUsage = new NoRemovableMediaUsage(name, true);
    if (securityAwareness != null) {
      AttackStep.allAttackSteps.remove(securityAwareness.disable);
    }
    Defense.allDefenses.remove(securityAwareness);
    securityAwareness = new SecurityAwareness(name, false);
    AttackStep.allAttackSteps.remove(bypassSecurityAwareness);
    bypassSecurityAwareness = new BypassSecurityAwareness(name);
    AttackStep.allAttackSteps.remove(securityAwarenessBypassed);
    securityAwarenessBypassed = new SecurityAwarenessBypassed(name);
    AttackStep.allAttackSteps.remove(oneCredentialCompromised);
    oneCredentialCompromised = new OneCredentialCompromised(name);
    AttackStep.allAttackSteps.remove(passwordReuseCompromise);
    passwordReuseCompromise = new PasswordReuseCompromise(name);
    AttackStep.allAttackSteps.remove(weakCredentials);
    weakCredentials = new WeakCredentials(name);
    AttackStep.allAttackSteps.remove(attemptSocialEngineering);
    attemptSocialEngineering = new AttemptSocialEngineering(name);
    AttackStep.allAttackSteps.remove(successfulSocialEngineering);
    successfulSocialEngineering = new SuccessfulSocialEngineering(name);
    AttackStep.allAttackSteps.remove(socialEngineering);
    socialEngineering = new SocialEngineering(name);
    AttackStep.allAttackSteps.remove(attemptDeliverMaliciousRemovableMedia);
    attemptDeliverMaliciousRemovableMedia = new AttemptDeliverMaliciousRemovableMedia(name);
    AttackStep.allAttackSteps.remove(successfulDeliverMaliciousRemovableMedia);
    successfulDeliverMaliciousRemovableMedia = new SuccessfulDeliverMaliciousRemovableMedia(name);
    AttackStep.allAttackSteps.remove(deliverMaliciousRemovableMedia);
    deliverMaliciousRemovableMedia = new DeliverMaliciousRemovableMedia(name);
    AttackStep.allAttackSteps.remove(credentialTheft);
    credentialTheft = new CredentialTheft(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
  }

  public User(boolean isNoPasswordReuseEnabled, boolean isNoRemovableMediaUsageEnabled,
      boolean isSecurityAwarenessEnabled) {
    this("Anonymous", isNoPasswordReuseEnabled, isNoRemovableMediaUsageEnabled, isSecurityAwarenessEnabled);
  }

  public User() {
    this("Anonymous");
  }

  public void addPhysicalZones(PhysicalZone physicalZones) {
    this.physicalZones.add(physicalZones);
    physicalZones.users.add(this);
  }

  public void addHardwareSystems(Hardware hardwareSystems) {
    this.hardwareSystems.add(hardwareSystems);
    hardwareSystems.users.add(this);
  }

  public void addUserIds(Identity userIds) {
    this.userIds.add(userIds);
    userIds.users.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("physicalZones")) {
      return PhysicalZone.class.getName();
    } else if (field.equals("hardwareSystems")) {
      return Hardware.class.getName();
    } else if (field.equals("userIds")) {
      return Identity.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("physicalZones")) {
      assets.addAll(physicalZones);
    } else if (field.equals("hardwareSystems")) {
      assets.addAll(hardwareSystems);
    } else if (field.equals("userIds")) {
      assets.addAll(userIds);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(physicalZones);
    assets.addAll(hardwareSystems);
    assets.addAll(userIds);
    return assets;
  }

  public class NoPasswordReuse extends Defense {
    public NoPasswordReuse(String name) {
      this(name, true);
    }

    public NoPasswordReuse(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNoPasswordReuse;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNoPasswordReuse == null) {
          _cacheChildrenNoPasswordReuse = new HashSet<>();
          _cacheChildrenNoPasswordReuse.add(passwordReuseCompromise);
        }
        for (AttackStep attackStep : _cacheChildrenNoPasswordReuse) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "User.noPasswordReuse";
      }
    }
  }

  public class NoRemovableMediaUsage extends Defense {
    public NoRemovableMediaUsage(String name) {
      this(name, true);
    }

    public NoRemovableMediaUsage(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNoRemovableMediaUsage;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNoRemovableMediaUsage == null) {
          _cacheChildrenNoRemovableMediaUsage = new HashSet<>();
          _cacheChildrenNoRemovableMediaUsage.add(successfulDeliverMaliciousRemovableMedia);
        }
        for (AttackStep attackStep : _cacheChildrenNoRemovableMediaUsage) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "User.noRemovableMediaUsage";
      }
    }
  }

  public class SecurityAwareness extends Defense {
    public SecurityAwareness(String name) {
      this(name, false);
    }

    public SecurityAwareness(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenSecurityAwareness;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenSecurityAwareness == null) {
          _cacheChildrenSecurityAwareness = new HashSet<>();
          _cacheChildrenSecurityAwareness.add(securityAwarenessBypassed);
          _cacheChildrenSecurityAwareness.add(weakCredentials);
        }
        for (AttackStep attackStep : _cacheChildrenSecurityAwareness) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "User.securityAwareness";
      }
    }
  }

  public class BypassSecurityAwareness extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassSecurityAwareness;

    private Set<AttackStep> _cacheParentBypassSecurityAwareness;

    public BypassSecurityAwareness(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassSecurityAwareness == null) {
        _cacheChildrenBypassSecurityAwareness = new HashSet<>();
        _cacheChildrenBypassSecurityAwareness.add(securityAwarenessBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassSecurityAwareness) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassSecurityAwareness == null) {
        _cacheParentBypassSecurityAwareness = new HashSet<>();
        _cacheParentBypassSecurityAwareness.add(attemptSocialEngineering);
        _cacheParentBypassSecurityAwareness.add(attemptDeliverMaliciousRemovableMedia);
      }
      for (AttackStep attackStep : _cacheParentBypassSecurityAwareness) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.bypassSecurityAwareness");
    }
  }

  public class SecurityAwarenessBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSecurityAwarenessBypassed;

    private Set<AttackStep> _cacheParentSecurityAwarenessBypassed;

    public SecurityAwarenessBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSecurityAwarenessBypassed == null) {
        _cacheChildrenSecurityAwarenessBypassed = new HashSet<>();
        _cacheChildrenSecurityAwarenessBypassed.add(successfulSocialEngineering);
        _cacheChildrenSecurityAwarenessBypassed.add(successfulDeliverMaliciousRemovableMedia);
      }
      for (AttackStep attackStep : _cacheChildrenSecurityAwarenessBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSecurityAwarenessBypassed == null) {
        _cacheParentSecurityAwarenessBypassed = new HashSet<>();
        _cacheParentSecurityAwarenessBypassed.add(securityAwareness.disable);
        _cacheParentSecurityAwarenessBypassed.add(bypassSecurityAwareness);
      }
      for (AttackStep attackStep : _cacheParentSecurityAwarenessBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.securityAwarenessBypassed");
    }
  }

  public class OneCredentialCompromised extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenOneCredentialCompromised;

    private Set<AttackStep> _cacheParentOneCredentialCompromised;

    public OneCredentialCompromised(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenOneCredentialCompromised == null) {
        _cacheChildrenOneCredentialCompromised = new HashSet<>();
        _cacheChildrenOneCredentialCompromised.add(passwordReuseCompromise);
      }
      for (AttackStep attackStep : _cacheChildrenOneCredentialCompromised) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentOneCredentialCompromised == null) {
        _cacheParentOneCredentialCompromised = new HashSet<>();
        for (Identity _0 : userIds) {
          for (Credentials _1 : _0.credentials) {
            Set<Credentials> _2 = new HashSet<>();
            List<Credentials> _3 = new ArrayList<>();
            _2.add(_1);
            _3.add(_1);
            while (!_3.isEmpty()) {
              Credentials _4 = _3.remove(0);
              for (Credentials _5 : _4.requiredFactors) {
                if (!_2.contains(_5)) {
                  _2.add(_5);
                  _3.add(_5);
                }
              }
            }
            for (Credentials _6 : _2) {
              _cacheParentOneCredentialCompromised.add(_6.propagateOneCredentialCompromised);
            }
          }
        }
      }
      for (AttackStep attackStep : _cacheParentOneCredentialCompromised) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.oneCredentialCompromised");
    }
  }

  public class PasswordReuseCompromise extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenPasswordReuseCompromise;

    private Set<AttackStep> _cacheParentPasswordReuseCompromise;

    public PasswordReuseCompromise(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenPasswordReuseCompromise == null) {
        _cacheChildrenPasswordReuseCompromise = new HashSet<>();
        for (Identity _0 : userIds) {
          for (Credentials _1 : _0.credentials) {
            _cacheChildrenPasswordReuseCompromise.add(_1.attemptCredentialsReuse);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenPasswordReuseCompromise) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentPasswordReuseCompromise == null) {
        _cacheParentPasswordReuseCompromise = new HashSet<>();
        _cacheParentPasswordReuseCompromise.add(noPasswordReuse.disable);
        _cacheParentPasswordReuseCompromise.add(oneCredentialCompromised);
      }
      for (AttackStep attackStep : _cacheParentPasswordReuseCompromise) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.passwordReuseCompromise");
    }
  }

  public class WeakCredentials extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenWeakCredentials;

    private Set<AttackStep> _cacheParentWeakCredentials;

    public WeakCredentials(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenWeakCredentials == null) {
        _cacheChildrenWeakCredentials = new HashSet<>();
        for (Identity _0 : userIds) {
          for (Credentials _1 : _0.credentials) {
            _cacheChildrenWeakCredentials.add(_1.weakCredentials);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenWeakCredentials) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentWeakCredentials == null) {
        _cacheParentWeakCredentials = new HashSet<>();
        _cacheParentWeakCredentials.add(securityAwareness.disable);
      }
      for (AttackStep attackStep : _cacheParentWeakCredentials) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.weakCredentials");
    }
  }

  public class AttemptSocialEngineering extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptSocialEngineering;

    public AttemptSocialEngineering(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptSocialEngineering == null) {
        _cacheChildrenAttemptSocialEngineering = new HashSet<>();
        _cacheChildrenAttemptSocialEngineering.add(successfulSocialEngineering);
        _cacheChildrenAttemptSocialEngineering.add(bypassSecurityAwareness);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptSocialEngineering) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.attemptSocialEngineering");
    }
  }

  public class SuccessfulSocialEngineering extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulSocialEngineering;

    private Set<AttackStep> _cacheParentSuccessfulSocialEngineering;

    public SuccessfulSocialEngineering(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulSocialEngineering == null) {
        _cacheChildrenSuccessfulSocialEngineering = new HashSet<>();
        _cacheChildrenSuccessfulSocialEngineering.add(socialEngineering);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulSocialEngineering) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulSocialEngineering == null) {
        _cacheParentSuccessfulSocialEngineering = new HashSet<>();
        _cacheParentSuccessfulSocialEngineering.add(securityAwarenessBypassed);
        _cacheParentSuccessfulSocialEngineering.add(attemptSocialEngineering);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulSocialEngineering) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.successfulSocialEngineering");
    }
  }

  public class SocialEngineering extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSocialEngineering;

    private Set<AttackStep> _cacheParentSocialEngineering;

    public SocialEngineering(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSocialEngineering == null) {
        _cacheChildrenSocialEngineering = new HashSet<>();
        _cacheChildrenSocialEngineering.add(credentialTheft);
        _cacheChildrenSocialEngineering.add(unsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheChildrenSocialEngineering) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSocialEngineering == null) {
        _cacheParentSocialEngineering = new HashSet<>();
        _cacheParentSocialEngineering.add(successfulSocialEngineering);
      }
      for (AttackStep attackStep : _cacheParentSocialEngineering) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.socialEngineering");
    }
  }

  public class AttemptDeliverMaliciousRemovableMedia extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDeliverMaliciousRemovableMedia;

    private Set<AttackStep> _cacheParentAttemptDeliverMaliciousRemovableMedia;

    public AttemptDeliverMaliciousRemovableMedia(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDeliverMaliciousRemovableMedia == null) {
        _cacheChildrenAttemptDeliverMaliciousRemovableMedia = new HashSet<>();
        _cacheChildrenAttemptDeliverMaliciousRemovableMedia.add(successfulDeliverMaliciousRemovableMedia);
        _cacheChildrenAttemptDeliverMaliciousRemovableMedia.add(bypassSecurityAwareness);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDeliverMaliciousRemovableMedia) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDeliverMaliciousRemovableMedia == null) {
        _cacheParentAttemptDeliverMaliciousRemovableMedia = new HashSet<>();
        Set<Hardware> _0 = new HashSet<>();
        Set<Hardware> _1 = new HashSet<>();
        for (PhysicalZone _2 : physicalZones) {
          for (Hardware _3 : _2.hardwareSystems) {
            _0.add(_3);
          }
        }
        for (Hardware _4 : hardwareSystems) {
          _1.add(_4);
        }
        _0.addAll(_1);
        for (Hardware _5 : _0) {
          _cacheParentAttemptDeliverMaliciousRemovableMedia.add(_5.spreadWormThroughRemovableMedia);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDeliverMaliciousRemovableMedia) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.attemptDeliverMaliciousRemovableMedia");
    }
  }

  public class SuccessfulDeliverMaliciousRemovableMedia extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulDeliverMaliciousRemovableMedia;

    private Set<AttackStep> _cacheParentSuccessfulDeliverMaliciousRemovableMedia;

    public SuccessfulDeliverMaliciousRemovableMedia(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulDeliverMaliciousRemovableMedia == null) {
        _cacheChildrenSuccessfulDeliverMaliciousRemovableMedia = new HashSet<>();
        _cacheChildrenSuccessfulDeliverMaliciousRemovableMedia.add(deliverMaliciousRemovableMedia);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulDeliverMaliciousRemovableMedia) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulDeliverMaliciousRemovableMedia == null) {
        _cacheParentSuccessfulDeliverMaliciousRemovableMedia = new HashSet<>();
        _cacheParentSuccessfulDeliverMaliciousRemovableMedia.add(noRemovableMediaUsage.disable);
        _cacheParentSuccessfulDeliverMaliciousRemovableMedia.add(securityAwarenessBypassed);
        _cacheParentSuccessfulDeliverMaliciousRemovableMedia.add(attemptDeliverMaliciousRemovableMedia);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulDeliverMaliciousRemovableMedia) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.successfulDeliverMaliciousRemovableMedia");
    }
  }

  public class DeliverMaliciousRemovableMedia extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDeliverMaliciousRemovableMedia;

    private Set<AttackStep> _cacheParentDeliverMaliciousRemovableMedia;

    public DeliverMaliciousRemovableMedia(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDeliverMaliciousRemovableMedia == null) {
        _cacheChildrenDeliverMaliciousRemovableMedia = new HashSet<>();
        for (Identity _0 : userIds) {
          _cacheChildrenDeliverMaliciousRemovableMedia.add(_0.attemptAssume);
        }
        for (PhysicalZone _1 : physicalZones) {
          for (Hardware _2 : _1.hardwareSystems) {
            _cacheChildrenDeliverMaliciousRemovableMedia.add(_2.attemptUnsafeUserActivity);
          }
        }
        for (Hardware _3 : hardwareSystems) {
          _cacheChildrenDeliverMaliciousRemovableMedia.add(_3.attemptUnsafeUserActivity);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDeliverMaliciousRemovableMedia) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDeliverMaliciousRemovableMedia == null) {
        _cacheParentDeliverMaliciousRemovableMedia = new HashSet<>();
        _cacheParentDeliverMaliciousRemovableMedia.add(successfulDeliverMaliciousRemovableMedia);
      }
      for (AttackStep attackStep : _cacheParentDeliverMaliciousRemovableMedia) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.deliverMaliciousRemovableMedia");
    }
  }

  public class CredentialTheft extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenCredentialTheft;

    private Set<AttackStep> _cacheParentCredentialTheft;

    public CredentialTheft(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCredentialTheft == null) {
        _cacheChildrenCredentialTheft = new HashSet<>();
        for (Identity _0 : userIds) {
          for (Credentials _1 : _0.credentials) {
            _cacheChildrenCredentialTheft.add(_1.attemptCredentialTheft);
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenCredentialTheft) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCredentialTheft == null) {
        _cacheParentCredentialTheft = new HashSet<>();
        _cacheParentCredentialTheft.add(socialEngineering);
      }
      for (AttackStep attackStep : _cacheParentCredentialTheft) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.credentialTheft");
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
        for (Identity _0 : userIds) {
          _cacheChildrenUnsafeUserActivity.add(_0.attemptAssume);
        }
        for (Identity _1 : userIds) {
          _cacheChildrenUnsafeUserActivity.add(_1.attemptUnsafeUserActivity);
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
        _cacheParentUnsafeUserActivity.add(socialEngineering);
      }
      for (AttackStep attackStep : _cacheParentUnsafeUserActivity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("User.unsafeUserActivity");
    }
  }
}
