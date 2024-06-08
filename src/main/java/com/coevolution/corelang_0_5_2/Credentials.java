package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Credentials extends Information {
  public NotDisclosed notDisclosed;

  public NotGuessable notGuessable;

  public Unique unique;

  public NotPhishable notPhishable;

  public UseLeakedCredentials useLeakedCredentials;

  public AttemptCredentialsReuse attemptCredentialsReuse;

  public CredentialsReuse credentialsReuse;

  public AttemptUse attemptUse;

  public Use use;

  public AttemptPropagateOneCredentialCompromised attemptPropagateOneCredentialCompromised;

  public PropagateOneCredentialCompromised propagateOneCredentialCompromised;

  public AttemptCredentialTheft attemptCredentialTheft;

  public CredentialTheft credentialTheft;

  public WeakCredentials weakCredentials;

  public CredsHashed credsHashed;

  public GuessCredentialsFromHash guessCredentialsFromHash;

  public GuessCredentials guessCredentials;

  public Set<Data> encryptedData = new HashSet<>();

  public Set<Data> signedData = new HashSet<>();

  public Credentials origCreds = null;

  public Set<Credentials> hashes = new HashSet<>();

  public Set<Credentials> requiredFactors = new HashSet<>();

  public Set<Credentials> credentials = new HashSet<>();

  public Set<Identity> identities = new HashSet<>();

  public Credentials(String name, boolean isNotDisclosedEnabled, boolean isNotGuessableEnabled,
      boolean isUniqueEnabled, boolean isNotPhishableEnabled) {
    super(name);
    assetClassName = "Credentials";
    if (notDisclosed != null) {
      AttackStep.allAttackSteps.remove(notDisclosed.disable);
    }
    Defense.allDefenses.remove(notDisclosed);
    notDisclosed = new NotDisclosed(name, isNotDisclosedEnabled);
    if (notGuessable != null) {
      AttackStep.allAttackSteps.remove(notGuessable.disable);
    }
    Defense.allDefenses.remove(notGuessable);
    notGuessable = new NotGuessable(name, isNotGuessableEnabled);
    if (unique != null) {
      AttackStep.allAttackSteps.remove(unique.disable);
    }
    Defense.allDefenses.remove(unique);
    unique = new Unique(name, isUniqueEnabled);
    if (notPhishable != null) {
      AttackStep.allAttackSteps.remove(notPhishable.disable);
    }
    Defense.allDefenses.remove(notPhishable);
    notPhishable = new NotPhishable(name, isNotPhishableEnabled);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(useLeakedCredentials);
    useLeakedCredentials = new UseLeakedCredentials(name);
    AttackStep.allAttackSteps.remove(attemptCredentialsReuse);
    attemptCredentialsReuse = new AttemptCredentialsReuse(name);
    AttackStep.allAttackSteps.remove(credentialsReuse);
    credentialsReuse = new CredentialsReuse(name);
    AttackStep.allAttackSteps.remove(attemptUse);
    attemptUse = new AttemptUse(name);
    AttackStep.allAttackSteps.remove(use);
    use = new Use(name);
    AttackStep.allAttackSteps.remove(attemptPropagateOneCredentialCompromised);
    attemptPropagateOneCredentialCompromised = new AttemptPropagateOneCredentialCompromised(name);
    AttackStep.allAttackSteps.remove(propagateOneCredentialCompromised);
    propagateOneCredentialCompromised = new PropagateOneCredentialCompromised(name);
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(attemptCredentialTheft);
    attemptCredentialTheft = new AttemptCredentialTheft(name);
    AttackStep.allAttackSteps.remove(credentialTheft);
    credentialTheft = new CredentialTheft(name);
    AttackStep.allAttackSteps.remove(weakCredentials);
    weakCredentials = new WeakCredentials(name);
    if (credsHashed != null) {
      AttackStep.allAttackSteps.remove(credsHashed.disable);
    }
    Defense.allDefenses.remove(credsHashed);
    credsHashed = new CredsHashed(name);
    AttackStep.allAttackSteps.remove(guessCredentialsFromHash);
    guessCredentialsFromHash = new GuessCredentialsFromHash(name);
    AttackStep.allAttackSteps.remove(guessCredentials);
    guessCredentials = new GuessCredentials(name);
  }

  public Credentials(String name) {
    super(name);
    assetClassName = "Credentials";
    if (notDisclosed != null) {
      AttackStep.allAttackSteps.remove(notDisclosed.disable);
    }
    Defense.allDefenses.remove(notDisclosed);
    notDisclosed = new NotDisclosed(name, true);
    if (notGuessable != null) {
      AttackStep.allAttackSteps.remove(notGuessable.disable);
    }
    Defense.allDefenses.remove(notGuessable);
    notGuessable = new NotGuessable(name, true);
    if (unique != null) {
      AttackStep.allAttackSteps.remove(unique.disable);
    }
    Defense.allDefenses.remove(unique);
    unique = new Unique(name, true);
    if (notPhishable != null) {
      AttackStep.allAttackSteps.remove(notPhishable.disable);
    }
    Defense.allDefenses.remove(notPhishable);
    notPhishable = new NotPhishable(name, false);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(useLeakedCredentials);
    useLeakedCredentials = new UseLeakedCredentials(name);
    AttackStep.allAttackSteps.remove(attemptCredentialsReuse);
    attemptCredentialsReuse = new AttemptCredentialsReuse(name);
    AttackStep.allAttackSteps.remove(credentialsReuse);
    credentialsReuse = new CredentialsReuse(name);
    AttackStep.allAttackSteps.remove(attemptUse);
    attemptUse = new AttemptUse(name);
    AttackStep.allAttackSteps.remove(use);
    use = new Use(name);
    AttackStep.allAttackSteps.remove(attemptPropagateOneCredentialCompromised);
    attemptPropagateOneCredentialCompromised = new AttemptPropagateOneCredentialCompromised(name);
    AttackStep.allAttackSteps.remove(propagateOneCredentialCompromised);
    propagateOneCredentialCompromised = new PropagateOneCredentialCompromised(name);
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(attemptCredentialTheft);
    attemptCredentialTheft = new AttemptCredentialTheft(name);
    AttackStep.allAttackSteps.remove(credentialTheft);
    credentialTheft = new CredentialTheft(name);
    AttackStep.allAttackSteps.remove(weakCredentials);
    weakCredentials = new WeakCredentials(name);
    if (credsHashed != null) {
      AttackStep.allAttackSteps.remove(credsHashed.disable);
    }
    Defense.allDefenses.remove(credsHashed);
    credsHashed = new CredsHashed(name);
    AttackStep.allAttackSteps.remove(guessCredentialsFromHash);
    guessCredentialsFromHash = new GuessCredentialsFromHash(name);
    AttackStep.allAttackSteps.remove(guessCredentials);
    guessCredentials = new GuessCredentials(name);
  }

  public Credentials(boolean isNotDisclosedEnabled, boolean isNotGuessableEnabled,
      boolean isUniqueEnabled, boolean isNotPhishableEnabled) {
    this("Anonymous", isNotDisclosedEnabled, isNotGuessableEnabled, isUniqueEnabled, isNotPhishableEnabled);
  }

  public Credentials() {
    this("Anonymous");
  }

  public void addEncryptedData(Data encryptedData) {
    this.encryptedData.add(encryptedData);
    encryptedData.encryptCreds = this;
  }

  public void addSignedData(Data signedData) {
    this.signedData.add(signedData);
    signedData.signingCreds = this;
  }

  public void addOrigCreds(Credentials origCreds) {
    this.origCreds = origCreds;
    origCreds.hashes.add(this);
  }

  public void addHashes(Credentials hashes) {
    this.hashes.add(hashes);
    hashes.origCreds = this;
  }

  public void addRequiredFactors(Credentials requiredFactors) {
    this.requiredFactors.add(requiredFactors);
    requiredFactors.credentials.add(this);
  }

  public void addCredentials(Credentials credentials) {
    this.credentials.add(credentials);
    credentials.requiredFactors.add(this);
  }

  public void addIdentities(Identity identities) {
    this.identities.add(identities);
    identities.credentials.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("encryptedData")) {
      return Data.class.getName();
    } else if (field.equals("signedData")) {
      return Data.class.getName();
    } else if (field.equals("origCreds")) {
      return Credentials.class.getName();
    } else if (field.equals("hashes")) {
      return Credentials.class.getName();
    } else if (field.equals("requiredFactors")) {
      return Credentials.class.getName();
    } else if (field.equals("credentials")) {
      return Credentials.class.getName();
    } else if (field.equals("identities")) {
      return Identity.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("encryptedData")) {
      assets.addAll(encryptedData);
    } else if (field.equals("signedData")) {
      assets.addAll(signedData);
    } else if (field.equals("origCreds")) {
      if (origCreds != null) {
        assets.add(origCreds);
      }
    } else if (field.equals("hashes")) {
      assets.addAll(hashes);
    } else if (field.equals("requiredFactors")) {
      assets.addAll(requiredFactors);
    } else if (field.equals("credentials")) {
      assets.addAll(credentials);
    } else if (field.equals("identities")) {
      assets.addAll(identities);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(encryptedData);
    assets.addAll(signedData);
    if (origCreds != null) {
      assets.add(origCreds);
    }
    assets.addAll(hashes);
    assets.addAll(requiredFactors);
    assets.addAll(credentials);
    assets.addAll(identities);
    return assets;
  }

  public class NotDisclosed extends Defense {
    public NotDisclosed(String name) {
      this(name, true);
    }

    public NotDisclosed(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNotDisclosed;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNotDisclosed == null) {
          _cacheChildrenNotDisclosed = new HashSet<>();
          _cacheChildrenNotDisclosed.add(useLeakedCredentials);
        }
        for (AttackStep attackStep : _cacheChildrenNotDisclosed) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Credentials.notDisclosed";
      }
    }
  }

  public class NotGuessable extends Defense {
    public NotGuessable(String name) {
      this(name, true);
    }

    public NotGuessable(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNotGuessable;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNotGuessable == null) {
          _cacheChildrenNotGuessable = new HashSet<>();
          _cacheChildrenNotGuessable.add(guessCredentials);
        }
        for (AttackStep attackStep : _cacheChildrenNotGuessable) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Credentials.notGuessable";
      }
    }
  }

  public class Unique extends Defense {
    public Unique(String name) {
      this(name, true);
    }

    public Unique(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenUnique;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenUnique == null) {
          _cacheChildrenUnique = new HashSet<>();
          _cacheChildrenUnique.add(credentialsReuse);
          _cacheChildrenUnique.add(propagateOneCredentialCompromised);
        }
        for (AttackStep attackStep : _cacheChildrenUnique) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Credentials.unique";
      }
    }
  }

  public class NotPhishable extends Defense {
    public NotPhishable(String name) {
      this(name, false);
    }

    public NotPhishable(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNotPhishable;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNotPhishable == null) {
          _cacheChildrenNotPhishable = new HashSet<>();
          _cacheChildrenNotPhishable.add(credentialTheft);
        }
        for (AttackStep attackStep : _cacheChildrenNotPhishable) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Credentials.notPhishable";
      }
    }
  }

  public class Read extends Information.Read {
    private Set<AttackStep> _cacheChildrenRead;

    public Read(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      super.updateChildren(attackSteps);
      if (_cacheChildrenRead == null) {
        _cacheChildrenRead = new HashSet<>();
        _cacheChildrenRead.add(attemptUse);
      }
      for (AttackStep attackStep : _cacheChildrenRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.read");
    }
  }

  public class UseLeakedCredentials extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenUseLeakedCredentials;

    private Set<AttackStep> _cacheParentUseLeakedCredentials;

    public UseLeakedCredentials(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUseLeakedCredentials == null) {
        _cacheChildrenUseLeakedCredentials = new HashSet<>();
        _cacheChildrenUseLeakedCredentials.add(attemptUse);
      }
      for (AttackStep attackStep : _cacheChildrenUseLeakedCredentials) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUseLeakedCredentials == null) {
        _cacheParentUseLeakedCredentials = new HashSet<>();
        _cacheParentUseLeakedCredentials.add(notDisclosed.disable);
      }
      for (AttackStep attackStep : _cacheParentUseLeakedCredentials) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.useLeakedCredentials");
    }
  }

  public class AttemptCredentialsReuse extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptCredentialsReuse;

    private Set<AttackStep> _cacheParentAttemptCredentialsReuse;

    public AttemptCredentialsReuse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptCredentialsReuse == null) {
        _cacheChildrenAttemptCredentialsReuse = new HashSet<>();
        _cacheChildrenAttemptCredentialsReuse.add(credentialsReuse);
        for (Credentials _0 : requiredFactors) {
          _cacheChildrenAttemptCredentialsReuse.add(_0.attemptCredentialsReuse);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAttemptCredentialsReuse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptCredentialsReuse == null) {
        _cacheParentAttemptCredentialsReuse = new HashSet<>();
        for (Credentials _1 : credentials) {
          _cacheParentAttemptCredentialsReuse.add(_1.attemptCredentialsReuse);
        }
        for (Identity _2 : identities) {
          for (User _3 : _2.users) {
            _cacheParentAttemptCredentialsReuse.add(_3.passwordReuseCompromise);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptCredentialsReuse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.attemptCredentialsReuse");
    }
  }

  public class CredentialsReuse extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenCredentialsReuse;

    private Set<AttackStep> _cacheParentCredentialsReuse;

    public CredentialsReuse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCredentialsReuse == null) {
        _cacheChildrenCredentialsReuse = new HashSet<>();
        _cacheChildrenCredentialsReuse.add(attemptUse);
      }
      for (AttackStep attackStep : _cacheChildrenCredentialsReuse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCredentialsReuse == null) {
        _cacheParentCredentialsReuse = new HashSet<>();
        _cacheParentCredentialsReuse.add(unique.disable);
        _cacheParentCredentialsReuse.add(attemptCredentialsReuse);
      }
      for (AttackStep attackStep : _cacheParentCredentialsReuse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.credentialsReuse");
    }
  }

  public class AttemptUse extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptUse;

    private Set<AttackStep> _cacheParentAttemptUse;

    public AttemptUse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptUse == null) {
        _cacheChildrenAttemptUse = new HashSet<>();
        _cacheChildrenAttemptUse.add(use);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptUse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptUse == null) {
        _cacheParentAttemptUse = new HashSet<>();
        _cacheParentAttemptUse.add(read);
        _cacheParentAttemptUse.add(useLeakedCredentials);
        _cacheParentAttemptUse.add(credentialsReuse);
        if (origCreds != null) {
          _cacheParentAttemptUse.add(origCreds.use);
        }
        _cacheParentAttemptUse.add(attemptAccess);
        _cacheParentAttemptUse.add(credentialTheft);
        _cacheParentAttemptUse.add(guessCredentials);
      }
      for (AttackStep attackStep : _cacheParentAttemptUse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.attemptUse");
    }
  }

  public class Use extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenUse;

    private Set<AttackStep> _cacheParentUse;

    public Use(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUse == null) {
        _cacheChildrenUse = new HashSet<>();
        for (Identity _0 : identities) {
          _cacheChildrenUse.add(_0.attemptAssume);
        }
        for (Data _1 : encryptedData) {
          _cacheChildrenUse.add(_1.accessDecryptedData);
        }
        for (Data _2 : signedData) {
          _cacheChildrenUse.add(_2.accessSpoofedData);
        }
        _cacheChildrenUse.add(attemptPropagateOneCredentialCompromised);
        for (Credentials _3 : credentials) {
          _cacheChildrenUse.add(_3.use);
        }
        for (Credentials _4 : hashes) {
          _cacheChildrenUse.add(_4.attemptUse);
        }
        if (origCreds != null) {
          _cacheChildrenUse.add(origCreds.guessCredentialsFromHash);
        }
      }
      for (AttackStep attackStep : _cacheChildrenUse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUse == null) {
        _cacheParentUse = new HashSet<>();
        _cacheParentUse.add(attemptUse);
        for (Credentials _5 : requiredFactors) {
          _cacheParentUse.add(_5.use);
        }
      }
      for (AttackStep attackStep : _cacheParentUse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.use");
    }
  }

  public class AttemptPropagateOneCredentialCompromised extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptPropagateOneCredentialCompromised;

    private Set<AttackStep> _cacheParentAttemptPropagateOneCredentialCompromised;

    public AttemptPropagateOneCredentialCompromised(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptPropagateOneCredentialCompromised == null) {
        _cacheChildrenAttemptPropagateOneCredentialCompromised = new HashSet<>();
        _cacheChildrenAttemptPropagateOneCredentialCompromised.add(propagateOneCredentialCompromised);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptPropagateOneCredentialCompromised) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptPropagateOneCredentialCompromised == null) {
        _cacheParentAttemptPropagateOneCredentialCompromised = new HashSet<>();
        _cacheParentAttemptPropagateOneCredentialCompromised.add(use);
      }
      for (AttackStep attackStep : _cacheParentAttemptPropagateOneCredentialCompromised) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.attemptPropagateOneCredentialCompromised");
    }
  }

  public class PropagateOneCredentialCompromised extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenPropagateOneCredentialCompromised;

    private Set<AttackStep> _cacheParentPropagateOneCredentialCompromised;

    public PropagateOneCredentialCompromised(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenPropagateOneCredentialCompromised == null) {
        _cacheChildrenPropagateOneCredentialCompromised = new HashSet<>();
        Set<Credentials> _0 = new HashSet<>();
        List<Credentials> _1 = new ArrayList<>();
        _0.add(Credentials.this);
        _1.add(Credentials.this);
        while (!_1.isEmpty()) {
          Credentials _2 = _1.remove(0);
          for (Credentials _3 : _2.credentials) {
            if (!_0.contains(_3)) {
              _0.add(_3);
              _1.add(_3);
            }
          }
        }
        for (Credentials _4 : _0) {
          for (Identity _5 : _4.identities) {
            for (User _6 : _5.users) {
              _cacheChildrenPropagateOneCredentialCompromised.add(_6.oneCredentialCompromised);
            }
          }
        }
      }
      for (AttackStep attackStep : _cacheChildrenPropagateOneCredentialCompromised) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentPropagateOneCredentialCompromised == null) {
        _cacheParentPropagateOneCredentialCompromised = new HashSet<>();
        _cacheParentPropagateOneCredentialCompromised.add(unique.disable);
        _cacheParentPropagateOneCredentialCompromised.add(attemptPropagateOneCredentialCompromised);
      }
      for (AttackStep attackStep : _cacheParentPropagateOneCredentialCompromised) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.propagateOneCredentialCompromised");
    }
  }

  public class AttemptAccess extends Information.AttemptAccess {
    private Set<AttackStep> _cacheChildrenAttemptAccess;

    public AttemptAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccess == null) {
        _cacheChildrenAttemptAccess = new HashSet<>();
        _cacheChildrenAttemptAccess.add(attemptUse);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.attemptAccess");
    }
  }

  public class AttemptCredentialTheft extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptCredentialTheft;

    private Set<AttackStep> _cacheParentAttemptCredentialTheft;

    public AttemptCredentialTheft(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptCredentialTheft == null) {
        _cacheChildrenAttemptCredentialTheft = new HashSet<>();
        _cacheChildrenAttemptCredentialTheft.add(credentialTheft);
        for (Credentials _0 : requiredFactors) {
          _cacheChildrenAttemptCredentialTheft.add(_0.attemptCredentialTheft);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAttemptCredentialTheft) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptCredentialTheft == null) {
        _cacheParentAttemptCredentialTheft = new HashSet<>();
        for (Credentials _1 : credentials) {
          _cacheParentAttemptCredentialTheft.add(_1.attemptCredentialTheft);
        }
        for (Identity _2 : identities) {
          for (User _3 : _2.users) {
            _cacheParentAttemptCredentialTheft.add(_3.credentialTheft);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptCredentialTheft) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.attemptCredentialTheft");
    }
  }

  public class CredentialTheft extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenCredentialTheft;

    private Set<AttackStep> _cacheParentCredentialTheft;

    public CredentialTheft(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCredentialTheft == null) {
        _cacheChildrenCredentialTheft = new HashSet<>();
        _cacheChildrenCredentialTheft.add(attemptUse);
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
        _cacheParentCredentialTheft.add(notPhishable.disable);
        _cacheParentCredentialTheft.add(attemptCredentialTheft);
      }
      for (AttackStep attackStep : _cacheParentCredentialTheft) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.credentialTheft");
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
        _cacheChildrenWeakCredentials.add(guessCredentials);
        for (Credentials _0 : requiredFactors) {
          _cacheChildrenWeakCredentials.add(_0.weakCredentials);
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
        for (Credentials _1 : credentials) {
          _cacheParentWeakCredentials.add(_1.weakCredentials);
        }
        for (Identity _2 : identities) {
          for (User _3 : _2.users) {
            _cacheParentWeakCredentials.add(_3.weakCredentials);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentWeakCredentials) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.weakCredentials");
    }
  }

  public class CredsHashed extends Defense {
    public CredsHashed(String name) {
      super(name);
      disable = new Disable(name);
    }

    @Override
    public boolean isEnabled() {
      int count = 1;
      for (Credentials _0 : hashes) {
        count--;
        break;
      }
      return count == 0;
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenCredsHashed;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenCredsHashed == null) {
          _cacheChildrenCredsHashed = new HashSet<>();
          _cacheChildrenCredsHashed.add(guessCredentialsFromHash);
        }
        for (AttackStep attackStep : _cacheChildrenCredsHashed) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Credentials.credsHashed";
      }
    }
  }

  public class GuessCredentialsFromHash extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenGuessCredentialsFromHash;

    private Set<AttackStep> _cacheParentGuessCredentialsFromHash;

    public GuessCredentialsFromHash(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenGuessCredentialsFromHash == null) {
        _cacheChildrenGuessCredentialsFromHash = new HashSet<>();
        _cacheChildrenGuessCredentialsFromHash.add(guessCredentials);
      }
      for (AttackStep attackStep : _cacheChildrenGuessCredentialsFromHash) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentGuessCredentialsFromHash == null) {
        _cacheParentGuessCredentialsFromHash = new HashSet<>();
        for (Credentials _0 : hashes) {
          _cacheParentGuessCredentialsFromHash.add(_0.use);
        }
        _cacheParentGuessCredentialsFromHash.add(credsHashed.disable);
      }
      for (AttackStep attackStep : _cacheParentGuessCredentialsFromHash) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.guessCredentialsFromHash");
    }
  }

  public class GuessCredentials extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenGuessCredentials;

    private Set<AttackStep> _cacheParentGuessCredentials;

    public GuessCredentials(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenGuessCredentials == null) {
        _cacheChildrenGuessCredentials = new HashSet<>();
        _cacheChildrenGuessCredentials.add(attemptUse);
      }
      for (AttackStep attackStep : _cacheChildrenGuessCredentials) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentGuessCredentials == null) {
        _cacheParentGuessCredentials = new HashSet<>();
        _cacheParentGuessCredentials.add(notGuessable.disable);
        _cacheParentGuessCredentials.add(weakCredentials);
        _cacheParentGuessCredentials.add(guessCredentialsFromHash);
      }
      for (AttackStep attackStep : _cacheParentGuessCredentials) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Credentials.guessCredentials");
    }
  }
}
