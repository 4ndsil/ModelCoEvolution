package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data extends Asset {
  public AttemptAccess attemptAccess;

  public AttemptAccessFromIdentity attemptAccessFromIdentity;

  public Access access;

  public DataEncrypted dataEncrypted;

  public DataSigned dataSigned;

  public AccessUnencryptedData accessUnencryptedData;

  public AccessUnsignedData accessUnsignedData;

  public AccessSpoofedData accessSpoofedData;

  public AccessDecryptedData accessDecryptedData;

  public DataNotPresent dataNotPresent;

  public ReadContainedInformation readContainedInformation;

  public AttemptApplicationRespondConnect attemptApplicationRespondConnect;

  public ApplicationRespondConnect applicationRespondConnect;

  public AttemptRead attemptRead;

  public IdentityAttemptRead identityAttemptRead;

  public IdentityRead identityRead;

  public AttemptWrite attemptWrite;

  public IdentityAttemptWrite identityAttemptWrite;

  public IdentityWrite identityWrite;

  public AttemptDelete attemptDelete;

  public IdentityAttemptDelete identityAttemptDelete;

  public IdentityDelete identityDelete;

  public SuccessfulRead successfulRead;

  public Read read;

  public SuccessfulWrite successfulWrite;

  public Write write;

  public SuccessfulDelete successfulDelete;

  public Delete delete;

  public AttemptDeny attemptDeny;

  public SuccessfulDeny successfulDeny;

  public Deny deny;

  public AttemptWriteDataInTransitFromApplication attemptWriteDataInTransitFromApplication;

  public AttemptIdentityWriteDataInTransitFromApplication attemptIdentityWriteDataInTransitFromApplication;

  public AttemptWriteDataInTransitFromConnectionRule attemptWriteDataInTransitFromConnectionRule;

  public IdentityWriteDataInTransit identityWriteDataInTransit;

  public WriteDataInTransit writeDataInTransit;

  public AttemptDenyDataInTransitFromApplication attemptDenyDataInTransitFromApplication;

  public AttemptDenyDataInTransitFromConnectionRule attemptDenyDataInTransitFromConnectionRule;

  public DenyDataInTransit denyDataInTransit;

  public AttemptReverseReach attemptReverseReach;

  public ReverseReach reverseReach;

  public Extract extract;

  public CompromiseAppOrigin compromiseAppOrigin;

  public Set<Data> containedData = new HashSet<>();

  public Set<Data> containingData = new HashSet<>();

  public Set<Application> containingApp = new HashSet<>();

  public Set<Application> senderApp = new HashSet<>();

  public Set<Application> receiverApp = new HashSet<>();

  public Set<Network> transitNetwork = new HashSet<>();

  public Hardware hardware = null;

  public Set<Information> information = new HashSet<>();

  public Set<Information> replicatedInformation = new HashSet<>();

  public Credentials encryptCreds = null;

  public Credentials signingCreds = null;

  public SoftwareProduct originSoftwareProduct = null;

  public Set<IAMObject> readingIAMs = new HashSet<>();

  public Set<IAMObject> writingIAMs = new HashSet<>();

  public Set<IAMObject> deletingIAMs = new HashSet<>();

  public Data(String name, boolean isDataNotPresentEnabled) {
    super(name);
    assetClassName = "Data";
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(attemptAccessFromIdentity);
    attemptAccessFromIdentity = new AttemptAccessFromIdentity(name);
    AttackStep.allAttackSteps.remove(access);
    access = new Access(name);
    if (dataEncrypted != null) {
      AttackStep.allAttackSteps.remove(dataEncrypted.disable);
    }
    Defense.allDefenses.remove(dataEncrypted);
    dataEncrypted = new DataEncrypted(name);
    if (dataSigned != null) {
      AttackStep.allAttackSteps.remove(dataSigned.disable);
    }
    Defense.allDefenses.remove(dataSigned);
    dataSigned = new DataSigned(name);
    AttackStep.allAttackSteps.remove(accessUnencryptedData);
    accessUnencryptedData = new AccessUnencryptedData(name);
    AttackStep.allAttackSteps.remove(accessUnsignedData);
    accessUnsignedData = new AccessUnsignedData(name);
    AttackStep.allAttackSteps.remove(accessSpoofedData);
    accessSpoofedData = new AccessSpoofedData(name);
    AttackStep.allAttackSteps.remove(accessDecryptedData);
    accessDecryptedData = new AccessDecryptedData(name);
    if (dataNotPresent != null) {
      AttackStep.allAttackSteps.remove(dataNotPresent.disable);
    }
    Defense.allDefenses.remove(dataNotPresent);
    dataNotPresent = new DataNotPresent(name, isDataNotPresentEnabled);
    AttackStep.allAttackSteps.remove(readContainedInformation);
    readContainedInformation = new ReadContainedInformation(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnect);
    attemptApplicationRespondConnect = new AttemptApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(applicationRespondConnect);
    applicationRespondConnect = new ApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(attemptRead);
    attemptRead = new AttemptRead(name);
    AttackStep.allAttackSteps.remove(identityAttemptRead);
    identityAttemptRead = new IdentityAttemptRead(name);
    AttackStep.allAttackSteps.remove(identityRead);
    identityRead = new IdentityRead(name);
    AttackStep.allAttackSteps.remove(attemptWrite);
    attemptWrite = new AttemptWrite(name);
    AttackStep.allAttackSteps.remove(identityAttemptWrite);
    identityAttemptWrite = new IdentityAttemptWrite(name);
    AttackStep.allAttackSteps.remove(identityWrite);
    identityWrite = new IdentityWrite(name);
    AttackStep.allAttackSteps.remove(attemptDelete);
    attemptDelete = new AttemptDelete(name);
    AttackStep.allAttackSteps.remove(identityAttemptDelete);
    identityAttemptDelete = new IdentityAttemptDelete(name);
    AttackStep.allAttackSteps.remove(identityDelete);
    identityDelete = new IdentityDelete(name);
    AttackStep.allAttackSteps.remove(successfulRead);
    successfulRead = new SuccessfulRead(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(successfulWrite);
    successfulWrite = new SuccessfulWrite(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
    AttackStep.allAttackSteps.remove(successfulDelete);
    successfulDelete = new SuccessfulDelete(name);
    AttackStep.allAttackSteps.remove(delete);
    delete = new Delete(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(successfulDeny);
    successfulDeny = new SuccessfulDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(attemptWriteDataInTransitFromApplication);
    attemptWriteDataInTransitFromApplication = new AttemptWriteDataInTransitFromApplication(name);
    AttackStep.allAttackSteps.remove(attemptIdentityWriteDataInTransitFromApplication);
    attemptIdentityWriteDataInTransitFromApplication = new AttemptIdentityWriteDataInTransitFromApplication(name);
    AttackStep.allAttackSteps.remove(attemptWriteDataInTransitFromConnectionRule);
    attemptWriteDataInTransitFromConnectionRule = new AttemptWriteDataInTransitFromConnectionRule(name);
    AttackStep.allAttackSteps.remove(identityWriteDataInTransit);
    identityWriteDataInTransit = new IdentityWriteDataInTransit(name);
    AttackStep.allAttackSteps.remove(writeDataInTransit);
    writeDataInTransit = new WriteDataInTransit(name);
    AttackStep.allAttackSteps.remove(attemptDenyDataInTransitFromApplication);
    attemptDenyDataInTransitFromApplication = new AttemptDenyDataInTransitFromApplication(name);
    AttackStep.allAttackSteps.remove(attemptDenyDataInTransitFromConnectionRule);
    attemptDenyDataInTransitFromConnectionRule = new AttemptDenyDataInTransitFromConnectionRule(name);
    AttackStep.allAttackSteps.remove(denyDataInTransit);
    denyDataInTransit = new DenyDataInTransit(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(extract);
    extract = new Extract(name);
    AttackStep.allAttackSteps.remove(compromiseAppOrigin);
    compromiseAppOrigin = new CompromiseAppOrigin(name);
  }

  public Data(String name) {
    super(name);
    assetClassName = "Data";
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(attemptAccessFromIdentity);
    attemptAccessFromIdentity = new AttemptAccessFromIdentity(name);
    AttackStep.allAttackSteps.remove(access);
    access = new Access(name);
    if (dataEncrypted != null) {
      AttackStep.allAttackSteps.remove(dataEncrypted.disable);
    }
    Defense.allDefenses.remove(dataEncrypted);
    dataEncrypted = new DataEncrypted(name);
    if (dataSigned != null) {
      AttackStep.allAttackSteps.remove(dataSigned.disable);
    }
    Defense.allDefenses.remove(dataSigned);
    dataSigned = new DataSigned(name);
    AttackStep.allAttackSteps.remove(accessUnencryptedData);
    accessUnencryptedData = new AccessUnencryptedData(name);
    AttackStep.allAttackSteps.remove(accessUnsignedData);
    accessUnsignedData = new AccessUnsignedData(name);
    AttackStep.allAttackSteps.remove(accessSpoofedData);
    accessSpoofedData = new AccessSpoofedData(name);
    AttackStep.allAttackSteps.remove(accessDecryptedData);
    accessDecryptedData = new AccessDecryptedData(name);
    if (dataNotPresent != null) {
      AttackStep.allAttackSteps.remove(dataNotPresent.disable);
    }
    Defense.allDefenses.remove(dataNotPresent);
    dataNotPresent = new DataNotPresent(name, false);
    AttackStep.allAttackSteps.remove(readContainedInformation);
    readContainedInformation = new ReadContainedInformation(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnect);
    attemptApplicationRespondConnect = new AttemptApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(applicationRespondConnect);
    applicationRespondConnect = new ApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(attemptRead);
    attemptRead = new AttemptRead(name);
    AttackStep.allAttackSteps.remove(identityAttemptRead);
    identityAttemptRead = new IdentityAttemptRead(name);
    AttackStep.allAttackSteps.remove(identityRead);
    identityRead = new IdentityRead(name);
    AttackStep.allAttackSteps.remove(attemptWrite);
    attemptWrite = new AttemptWrite(name);
    AttackStep.allAttackSteps.remove(identityAttemptWrite);
    identityAttemptWrite = new IdentityAttemptWrite(name);
    AttackStep.allAttackSteps.remove(identityWrite);
    identityWrite = new IdentityWrite(name);
    AttackStep.allAttackSteps.remove(attemptDelete);
    attemptDelete = new AttemptDelete(name);
    AttackStep.allAttackSteps.remove(identityAttemptDelete);
    identityAttemptDelete = new IdentityAttemptDelete(name);
    AttackStep.allAttackSteps.remove(identityDelete);
    identityDelete = new IdentityDelete(name);
    AttackStep.allAttackSteps.remove(successfulRead);
    successfulRead = new SuccessfulRead(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(successfulWrite);
    successfulWrite = new SuccessfulWrite(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
    AttackStep.allAttackSteps.remove(successfulDelete);
    successfulDelete = new SuccessfulDelete(name);
    AttackStep.allAttackSteps.remove(delete);
    delete = new Delete(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(successfulDeny);
    successfulDeny = new SuccessfulDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(attemptWriteDataInTransitFromApplication);
    attemptWriteDataInTransitFromApplication = new AttemptWriteDataInTransitFromApplication(name);
    AttackStep.allAttackSteps.remove(attemptIdentityWriteDataInTransitFromApplication);
    attemptIdentityWriteDataInTransitFromApplication = new AttemptIdentityWriteDataInTransitFromApplication(name);
    AttackStep.allAttackSteps.remove(attemptWriteDataInTransitFromConnectionRule);
    attemptWriteDataInTransitFromConnectionRule = new AttemptWriteDataInTransitFromConnectionRule(name);
    AttackStep.allAttackSteps.remove(identityWriteDataInTransit);
    identityWriteDataInTransit = new IdentityWriteDataInTransit(name);
    AttackStep.allAttackSteps.remove(writeDataInTransit);
    writeDataInTransit = new WriteDataInTransit(name);
    AttackStep.allAttackSteps.remove(attemptDenyDataInTransitFromApplication);
    attemptDenyDataInTransitFromApplication = new AttemptDenyDataInTransitFromApplication(name);
    AttackStep.allAttackSteps.remove(attemptDenyDataInTransitFromConnectionRule);
    attemptDenyDataInTransitFromConnectionRule = new AttemptDenyDataInTransitFromConnectionRule(name);
    AttackStep.allAttackSteps.remove(denyDataInTransit);
    denyDataInTransit = new DenyDataInTransit(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(extract);
    extract = new Extract(name);
    AttackStep.allAttackSteps.remove(compromiseAppOrigin);
    compromiseAppOrigin = new CompromiseAppOrigin(name);
  }

  public Data(boolean isDataNotPresentEnabled) {
    this("Anonymous", isDataNotPresentEnabled);
  }

  public Data() {
    this("Anonymous");
  }

  public void addContainedData(Data containedData) {
    this.containedData.add(containedData);
    containedData.containingData.add(this);
  }

  public void addContainingData(Data containingData) {
    this.containingData.add(containingData);
    containingData.containedData.add(this);
  }

  public void addContainingApp(Application containingApp) {
    this.containingApp.add(containingApp);
    containingApp.containedData.add(this);
  }

  public void addSenderApp(Application senderApp) {
    this.senderApp.add(senderApp);
    senderApp.sentData.add(this);
  }

  public void addReceiverApp(Application receiverApp) {
    this.receiverApp.add(receiverApp);
    receiverApp.receivedData.add(this);
  }

  public void addTransitNetwork(Network transitNetwork) {
    this.transitNetwork.add(transitNetwork);
    transitNetwork.transitData.add(this);
  }

  public void addHardware(Hardware hardware) {
    this.hardware = hardware;
    hardware.hostedData.add(this);
  }

  public void addInformation(Information information) {
    this.information.add(information);
    information.containerData.add(this);
  }

  public void addReplicatedInformation(Information replicatedInformation) {
    this.replicatedInformation.add(replicatedInformation);
    replicatedInformation.dataReplicas.add(this);
  }

  public void addEncryptCreds(Credentials encryptCreds) {
    this.encryptCreds = encryptCreds;
    encryptCreds.encryptedData.add(this);
  }

  public void addSigningCreds(Credentials signingCreds) {
    this.signingCreds = signingCreds;
    signingCreds.signedData.add(this);
  }

  public void addOriginSoftwareProduct(SoftwareProduct originSoftwareProduct) {
    this.originSoftwareProduct = originSoftwareProduct;
    originSoftwareProduct.originData = this;
  }

  public void addReadingIAMs(IAMObject readingIAMs) {
    this.readingIAMs.add(readingIAMs);
    readingIAMs.readPrivData.add(this);
  }

  public void addWritingIAMs(IAMObject writingIAMs) {
    this.writingIAMs.add(writingIAMs);
    writingIAMs.writePrivData.add(this);
  }

  public void addDeletingIAMs(IAMObject deletingIAMs) {
    this.deletingIAMs.add(deletingIAMs);
    deletingIAMs.deletePrivData.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("containedData")) {
      return Data.class.getName();
    } else if (field.equals("containingData")) {
      return Data.class.getName();
    } else if (field.equals("containingApp")) {
      return Application.class.getName();
    } else if (field.equals("senderApp")) {
      return Application.class.getName();
    } else if (field.equals("receiverApp")) {
      return Application.class.getName();
    } else if (field.equals("transitNetwork")) {
      return Network.class.getName();
    } else if (field.equals("hardware")) {
      return Hardware.class.getName();
    } else if (field.equals("information")) {
      return Information.class.getName();
    } else if (field.equals("replicatedInformation")) {
      return Information.class.getName();
    } else if (field.equals("encryptCreds")) {
      return Credentials.class.getName();
    } else if (field.equals("signingCreds")) {
      return Credentials.class.getName();
    } else if (field.equals("originSoftwareProduct")) {
      return SoftwareProduct.class.getName();
    } else if (field.equals("readingIAMs")) {
      return IAMObject.class.getName();
    } else if (field.equals("writingIAMs")) {
      return IAMObject.class.getName();
    } else if (field.equals("deletingIAMs")) {
      return IAMObject.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("containedData")) {
      assets.addAll(containedData);
    } else if (field.equals("containingData")) {
      assets.addAll(containingData);
    } else if (field.equals("containingApp")) {
      assets.addAll(containingApp);
    } else if (field.equals("senderApp")) {
      assets.addAll(senderApp);
    } else if (field.equals("receiverApp")) {
      assets.addAll(receiverApp);
    } else if (field.equals("transitNetwork")) {
      assets.addAll(transitNetwork);
    } else if (field.equals("hardware")) {
      if (hardware != null) {
        assets.add(hardware);
      }
    } else if (field.equals("information")) {
      assets.addAll(information);
    } else if (field.equals("replicatedInformation")) {
      assets.addAll(replicatedInformation);
    } else if (field.equals("encryptCreds")) {
      if (encryptCreds != null) {
        assets.add(encryptCreds);
      }
    } else if (field.equals("signingCreds")) {
      if (signingCreds != null) {
        assets.add(signingCreds);
      }
    } else if (field.equals("originSoftwareProduct")) {
      if (originSoftwareProduct != null) {
        assets.add(originSoftwareProduct);
      }
    } else if (field.equals("readingIAMs")) {
      assets.addAll(readingIAMs);
    } else if (field.equals("writingIAMs")) {
      assets.addAll(writingIAMs);
    } else if (field.equals("deletingIAMs")) {
      assets.addAll(deletingIAMs);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(containedData);
    assets.addAll(containingData);
    assets.addAll(containingApp);
    assets.addAll(senderApp);
    assets.addAll(receiverApp);
    assets.addAll(transitNetwork);
    if (hardware != null) {
      assets.add(hardware);
    }
    assets.addAll(information);
    assets.addAll(replicatedInformation);
    if (encryptCreds != null) {
      assets.add(encryptCreds);
    }
    if (signingCreds != null) {
      assets.add(signingCreds);
    }
    if (originSoftwareProduct != null) {
      assets.add(originSoftwareProduct);
    }
    assets.addAll(readingIAMs);
    assets.addAll(writingIAMs);
    assets.addAll(deletingIAMs);
    return assets;
  }

  public class AttemptAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAccess;

    private Set<AttackStep> _cacheParentAttemptAccess;

    public AttemptAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccess == null) {
        _cacheChildrenAttemptAccess = new HashSet<>();
        _cacheChildrenAttemptAccess.add(access);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccess == null) {
        _cacheParentAttemptAccess = new HashSet<>();
        if (hardware != null) {
          _cacheParentAttemptAccess.add(hardware.fullAccess);
        }
        for (Application _0 : containingApp) {
          _cacheParentAttemptAccess.add(_0.fullAccess);
        }
        for (Application _1 : containingApp) {
          _cacheParentAttemptAccess.add(_1.modify);
        }
        for (Data _2 : containingData) {
          _cacheParentAttemptAccess.add(_2.access);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptAccess");
    }
  }

  public class AttemptAccessFromIdentity extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAccessFromIdentity;

    private Set<AttackStep> _cacheParentAttemptAccessFromIdentity;

    public AttemptAccessFromIdentity(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccessFromIdentity == null) {
        _cacheChildrenAttemptAccessFromIdentity = new HashSet<>();
        _cacheChildrenAttemptAccessFromIdentity.add(identityRead);
        _cacheChildrenAttemptAccessFromIdentity.add(identityWrite);
        _cacheChildrenAttemptAccessFromIdentity.add(identityDelete);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccessFromIdentity) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccessFromIdentity == null) {
        _cacheParentAttemptAccessFromIdentity = new HashSet<>();
        for (Application _0 : containingApp) {
          _cacheParentAttemptAccessFromIdentity.add(_0.specificAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAccessFromIdentity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptAccessFromIdentity");
    }
  }

  public class Access extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAccess;

    private Set<AttackStep> _cacheParentAccess;

    public Access(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccess == null) {
        _cacheChildrenAccess = new HashSet<>();
        _cacheChildrenAccess.add(attemptRead);
        _cacheChildrenAccess.add(attemptWrite);
        _cacheChildrenAccess.add(attemptDelete);
        for (Data _0 : containedData) {
          _cacheChildrenAccess.add(_0.attemptAccess);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccess == null) {
        _cacheParentAccess = new HashSet<>();
        _cacheParentAccess.add(attemptAccess);
        _cacheParentAccess.add(accessDecryptedData);
        _cacheParentAccess.add(dataNotPresent.disable);
      }
      for (AttackStep attackStep : _cacheParentAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.access");
    }
  }

  public class DataEncrypted extends Defense {
    public DataEncrypted(String name) {
      super(name);
      disable = new Disable(name);
    }

    @Override
    public boolean isEnabled() {
      int count = 1;
      if (encryptCreds != null) {
        count--;
      }
      return count == 0;
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenDataEncrypted;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenDataEncrypted == null) {
          _cacheChildrenDataEncrypted = new HashSet<>();
          _cacheChildrenDataEncrypted.add(accessUnencryptedData);
        }
        for (AttackStep attackStep : _cacheChildrenDataEncrypted) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Data.dataEncrypted";
      }
    }
  }

  public class DataSigned extends Defense {
    public DataSigned(String name) {
      super(name);
      disable = new Disable(name);
    }

    @Override
    public boolean isEnabled() {
      int count = 1;
      if (signingCreds != null) {
        count--;
      }
      return count == 0;
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenDataSigned;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenDataSigned == null) {
          _cacheChildrenDataSigned = new HashSet<>();
          _cacheChildrenDataSigned.add(accessUnsignedData);
        }
        for (AttackStep attackStep : _cacheChildrenDataSigned) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Data.dataSigned";
      }
    }
  }

  public class AccessUnencryptedData extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAccessUnencryptedData;

    private Set<AttackStep> _cacheParentAccessUnencryptedData;

    public AccessUnencryptedData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessUnencryptedData == null) {
        _cacheChildrenAccessUnencryptedData = new HashSet<>();
        _cacheChildrenAccessUnencryptedData.add(accessDecryptedData);
      }
      for (AttackStep attackStep : _cacheChildrenAccessUnencryptedData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessUnencryptedData == null) {
        _cacheParentAccessUnencryptedData = new HashSet<>();
        _cacheParentAccessUnencryptedData.add(dataEncrypted.disable);
      }
      for (AttackStep attackStep : _cacheParentAccessUnencryptedData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.accessUnencryptedData");
    }
  }

  public class AccessUnsignedData extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAccessUnsignedData;

    private Set<AttackStep> _cacheParentAccessUnsignedData;

    public AccessUnsignedData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessUnsignedData == null) {
        _cacheChildrenAccessUnsignedData = new HashSet<>();
        _cacheChildrenAccessUnsignedData.add(accessSpoofedData);
      }
      for (AttackStep attackStep : _cacheChildrenAccessUnsignedData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessUnsignedData == null) {
        _cacheParentAccessUnsignedData = new HashSet<>();
        _cacheParentAccessUnsignedData.add(dataSigned.disable);
      }
      for (AttackStep attackStep : _cacheParentAccessUnsignedData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.accessUnsignedData");
    }
  }

  public class AccessSpoofedData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessSpoofedData;

    private Set<AttackStep> _cacheParentAccessSpoofedData;

    public AccessSpoofedData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessSpoofedData == null) {
        _cacheChildrenAccessSpoofedData = new HashSet<>();
        Set<Data> _0 = new HashSet<>();
        List<Data> _1 = new ArrayList<>();
        _0.add(Data.this);
        _1.add(Data.this);
        while (!_1.isEmpty()) {
          Data _2 = _1.remove(0);
          for (Data _3 : _2.containedData) {
            if (!_0.contains(_3)) {
              _0.add(_3);
              _1.add(_3);
            }
          }
        }
        for (Data _4 : _0) {
          _cacheChildrenAccessSpoofedData.add(_4.applicationRespondConnect);
        }
        Set<Data> _5 = new HashSet<>();
        List<Data> _6 = new ArrayList<>();
        _5.add(Data.this);
        _6.add(Data.this);
        while (!_6.isEmpty()) {
          Data _7 = _6.remove(0);
          for (Data _8 : _7.containedData) {
            if (!_5.contains(_8)) {
              _5.add(_8);
              _6.add(_8);
            }
          }
        }
        for (Data _9 : _5) {
          _cacheChildrenAccessSpoofedData.add(_9.successfulWrite);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAccessSpoofedData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessSpoofedData == null) {
        _cacheParentAccessSpoofedData = new HashSet<>();
        _cacheParentAccessSpoofedData.add(accessUnsignedData);
        if (signingCreds != null) {
          _cacheParentAccessSpoofedData.add(signingCreds.use);
        }
      }
      for (AttackStep attackStep : _cacheParentAccessSpoofedData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.accessSpoofedData");
    }
  }

  public class AccessDecryptedData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessDecryptedData;

    private Set<AttackStep> _cacheParentAccessDecryptedData;

    public AccessDecryptedData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessDecryptedData == null) {
        _cacheChildrenAccessDecryptedData = new HashSet<>();
        _cacheChildrenAccessDecryptedData.add(access);
        _cacheChildrenAccessDecryptedData.add(readContainedInformation);
        _cacheChildrenAccessDecryptedData.add(applicationRespondConnect);
        _cacheChildrenAccessDecryptedData.add(successfulRead);
        _cacheChildrenAccessDecryptedData.add(successfulWrite);
        _cacheChildrenAccessDecryptedData.add(successfulDelete);
      }
      for (AttackStep attackStep : _cacheChildrenAccessDecryptedData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessDecryptedData == null) {
        _cacheParentAccessDecryptedData = new HashSet<>();
        _cacheParentAccessDecryptedData.add(accessUnencryptedData);
        if (encryptCreds != null) {
          _cacheParentAccessDecryptedData.add(encryptCreds.use);
        }
      }
      for (AttackStep attackStep : _cacheParentAccessDecryptedData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.accessDecryptedData");
    }
  }

  public class DataNotPresent extends Defense {
    public DataNotPresent(String name) {
      this(name, false);
    }

    public DataNotPresent(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenDataNotPresent;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenDataNotPresent == null) {
          _cacheChildrenDataNotPresent = new HashSet<>();
          _cacheChildrenDataNotPresent.add(access);
          _cacheChildrenDataNotPresent.add(readContainedInformation);
          _cacheChildrenDataNotPresent.add(applicationRespondConnect);
          _cacheChildrenDataNotPresent.add(successfulRead);
          _cacheChildrenDataNotPresent.add(successfulWrite);
          _cacheChildrenDataNotPresent.add(successfulDeny);
          _cacheChildrenDataNotPresent.add(successfulDelete);
        }
        for (AttackStep attackStep : _cacheChildrenDataNotPresent) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Data.dataNotPresent";
      }
    }
  }

  public class ReadContainedInformation extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenReadContainedInformation;

    private Set<AttackStep> _cacheParentReadContainedInformation;

    public ReadContainedInformation(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReadContainedInformation == null) {
        _cacheChildrenReadContainedInformation = new HashSet<>();
        for (Information _0 : information) {
          _cacheChildrenReadContainedInformation.add(_0.attemptAccess);
        }
      }
      for (AttackStep attackStep : _cacheChildrenReadContainedInformation) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReadContainedInformation == null) {
        _cacheParentReadContainedInformation = new HashSet<>();
        _cacheParentReadContainedInformation.add(accessDecryptedData);
        _cacheParentReadContainedInformation.add(dataNotPresent.disable);
        _cacheParentReadContainedInformation.add(read);
      }
      for (AttackStep attackStep : _cacheParentReadContainedInformation) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.readContainedInformation");
    }
  }

  public class AttemptApplicationRespondConnect extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptApplicationRespondConnect;

    private Set<AttackStep> _cacheParentAttemptApplicationRespondConnect;

    public AttemptApplicationRespondConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptApplicationRespondConnect == null) {
        _cacheChildrenAttemptApplicationRespondConnect = new HashSet<>();
        _cacheChildrenAttemptApplicationRespondConnect.add(applicationRespondConnect);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptApplicationRespondConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptApplicationRespondConnect == null) {
        _cacheParentAttemptApplicationRespondConnect = new HashSet<>();
        for (Application _0 : receiverApp) {
          _cacheParentAttemptApplicationRespondConnect.add(_0.applicationRespondConnectThroughData);
        }
        for (Network _1 : transitNetwork) {
          _cacheParentAttemptApplicationRespondConnect.add(_1.successfulManInTheMiddle);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptApplicationRespondConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptApplicationRespondConnect");
    }
  }

  public class ApplicationRespondConnect extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenApplicationRespondConnect;

    private Set<AttackStep> _cacheParentApplicationRespondConnect;

    public ApplicationRespondConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenApplicationRespondConnect == null) {
        _cacheChildrenApplicationRespondConnect = new HashSet<>();
        for (Application _0 : senderApp) {
          _cacheChildrenApplicationRespondConnect.add(_0.attemptNetworkConnectViaResponse);
        }
      }
      for (AttackStep attackStep : _cacheChildrenApplicationRespondConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentApplicationRespondConnect == null) {
        _cacheParentApplicationRespondConnect = new HashSet<>();
        Set<Data> _1 = new HashSet<>();
        List<Data> _2 = new ArrayList<>();
        _1.add(Data.this);
        _2.add(Data.this);
        while (!_2.isEmpty()) {
          Data _3 = _2.remove(0);
          for (Data _4 : _3.containingData) {
            if (!_1.contains(_4)) {
              _1.add(_4);
              _2.add(_4);
            }
          }
        }
        for (Data _5 : _1) {
          _cacheParentApplicationRespondConnect.add(_5.accessSpoofedData);
        }
        _cacheParentApplicationRespondConnect.add(accessDecryptedData);
        _cacheParentApplicationRespondConnect.add(dataNotPresent.disable);
        _cacheParentApplicationRespondConnect.add(attemptApplicationRespondConnect);
      }
      for (AttackStep attackStep : _cacheParentApplicationRespondConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.applicationRespondConnect");
    }
  }

  public class AttemptRead extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptRead;

    private Set<AttackStep> _cacheParentAttemptRead;

    public AttemptRead(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptRead == null) {
        _cacheChildrenAttemptRead = new HashSet<>();
        _cacheChildrenAttemptRead.add(successfulRead);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptRead == null) {
        _cacheParentAttemptRead = new HashSet<>();
        if (hardware != null) {
          _cacheParentAttemptRead.add(hardware.read);
        }
        for (Application _0 : senderApp) {
          _cacheParentAttemptRead.add(_0.fullAccess);
        }
        for (Application _1 : receiverApp) {
          _cacheParentAttemptRead.add(_1.fullAccess);
        }
        for (Application _2 : containingApp) {
          _cacheParentAttemptRead.add(_2.read);
        }
        _cacheParentAttemptRead.add(access);
        _cacheParentAttemptRead.add(identityRead);
        for (Data _3 : containingData) {
          _cacheParentAttemptRead.add(_3.read);
        }
        for (Network _4 : transitNetwork) {
          _cacheParentAttemptRead.add(_4.successfulEavesdrop);
        }
        for (Network _5 : transitNetwork) {
          _cacheParentAttemptRead.add(_5.successfulManInTheMiddle);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptRead");
    }
  }

  public class IdentityAttemptRead extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenIdentityAttemptRead;

    private Set<AttackStep> _cacheParentIdentityAttemptRead;

    public IdentityAttemptRead(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenIdentityAttemptRead == null) {
        _cacheChildrenIdentityAttemptRead = new HashSet<>();
        _cacheChildrenIdentityAttemptRead.add(identityRead);
      }
      for (AttackStep attackStep : _cacheChildrenIdentityAttemptRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentIdentityAttemptRead == null) {
        _cacheParentIdentityAttemptRead = new HashSet<>();
        for (Application _0 : senderApp) {
          _cacheParentIdentityAttemptRead.add(_0.specificAccess);
        }
        for (Application _1 : receiverApp) {
          _cacheParentIdentityAttemptRead.add(_1.specificAccess);
        }
        for (IAMObject _2 : readingIAMs) {
          _cacheParentIdentityAttemptRead.add(_2.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentIdentityAttemptRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.identityAttemptRead");
    }
  }

  public class IdentityRead extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenIdentityRead;

    private Set<AttackStep> _cacheParentIdentityRead;

    public IdentityRead(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenIdentityRead == null) {
        _cacheChildrenIdentityRead = new HashSet<>();
        _cacheChildrenIdentityRead.add(attemptRead);
      }
      for (AttackStep attackStep : _cacheChildrenIdentityRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentIdentityRead == null) {
        _cacheParentIdentityRead = new HashSet<>();
        _cacheParentIdentityRead.add(attemptAccessFromIdentity);
        _cacheParentIdentityRead.add(identityAttemptRead);
      }
      for (AttackStep attackStep : _cacheParentIdentityRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.identityRead");
    }
  }

  public class AttemptWrite extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptWrite;

    private Set<AttackStep> _cacheParentAttemptWrite;

    public AttemptWrite(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptWrite == null) {
        _cacheChildrenAttemptWrite = new HashSet<>();
        _cacheChildrenAttemptWrite.add(successfulWrite);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptWrite) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptWrite == null) {
        _cacheParentAttemptWrite = new HashSet<>();
        if (hardware != null) {
          _cacheParentAttemptWrite.add(hardware.modify);
        }
        _cacheParentAttemptWrite.add(access);
        _cacheParentAttemptWrite.add(identityWrite);
        for (Data _0 : containingData) {
          _cacheParentAttemptWrite.add(_0.write);
        }
        _cacheParentAttemptWrite.add(writeDataInTransit);
        for (Network _1 : transitNetwork) {
          _cacheParentAttemptWrite.add(_1.successfulManInTheMiddle);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptWrite) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptWrite");
    }
  }

  public class IdentityAttemptWrite extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenIdentityAttemptWrite;

    private Set<AttackStep> _cacheParentIdentityAttemptWrite;

    public IdentityAttemptWrite(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenIdentityAttemptWrite == null) {
        _cacheChildrenIdentityAttemptWrite = new HashSet<>();
        _cacheChildrenIdentityAttemptWrite.add(identityWrite);
      }
      for (AttackStep attackStep : _cacheChildrenIdentityAttemptWrite) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentIdentityAttemptWrite == null) {
        _cacheParentIdentityAttemptWrite = new HashSet<>();
        _cacheParentIdentityAttemptWrite.add(identityWriteDataInTransit);
        for (IAMObject _0 : writingIAMs) {
          _cacheParentIdentityAttemptWrite.add(_0.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentIdentityAttemptWrite) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.identityAttemptWrite");
    }
  }

  public class IdentityWrite extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenIdentityWrite;

    private Set<AttackStep> _cacheParentIdentityWrite;

    public IdentityWrite(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenIdentityWrite == null) {
        _cacheChildrenIdentityWrite = new HashSet<>();
        _cacheChildrenIdentityWrite.add(attemptWrite);
      }
      for (AttackStep attackStep : _cacheChildrenIdentityWrite) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentIdentityWrite == null) {
        _cacheParentIdentityWrite = new HashSet<>();
        _cacheParentIdentityWrite.add(attemptAccessFromIdentity);
        _cacheParentIdentityWrite.add(identityAttemptWrite);
      }
      for (AttackStep attackStep : _cacheParentIdentityWrite) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.identityWrite");
    }
  }

  public class AttemptDelete extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDelete;

    private Set<AttackStep> _cacheParentAttemptDelete;

    public AttemptDelete(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDelete == null) {
        _cacheChildrenAttemptDelete = new HashSet<>();
        _cacheChildrenAttemptDelete.add(successfulDelete);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDelete) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDelete == null) {
        _cacheParentAttemptDelete = new HashSet<>();
        _cacheParentAttemptDelete.add(access);
        _cacheParentAttemptDelete.add(identityDelete);
        _cacheParentAttemptDelete.add(write);
        for (Data _0 : containingData) {
          _cacheParentAttemptDelete.add(_0.delete);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDelete) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptDelete");
    }
  }

  public class IdentityAttemptDelete extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenIdentityAttemptDelete;

    private Set<AttackStep> _cacheParentIdentityAttemptDelete;

    public IdentityAttemptDelete(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenIdentityAttemptDelete == null) {
        _cacheChildrenIdentityAttemptDelete = new HashSet<>();
        _cacheChildrenIdentityAttemptDelete.add(identityDelete);
      }
      for (AttackStep attackStep : _cacheChildrenIdentityAttemptDelete) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentIdentityAttemptDelete == null) {
        _cacheParentIdentityAttemptDelete = new HashSet<>();
        for (IAMObject _0 : deletingIAMs) {
          _cacheParentIdentityAttemptDelete.add(_0.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentIdentityAttemptDelete) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.identityAttemptDelete");
    }
  }

  public class IdentityDelete extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenIdentityDelete;

    private Set<AttackStep> _cacheParentIdentityDelete;

    public IdentityDelete(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenIdentityDelete == null) {
        _cacheChildrenIdentityDelete = new HashSet<>();
        _cacheChildrenIdentityDelete.add(attemptDelete);
      }
      for (AttackStep attackStep : _cacheChildrenIdentityDelete) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentIdentityDelete == null) {
        _cacheParentIdentityDelete = new HashSet<>();
        _cacheParentIdentityDelete.add(attemptAccessFromIdentity);
        _cacheParentIdentityDelete.add(identityAttemptDelete);
      }
      for (AttackStep attackStep : _cacheParentIdentityDelete) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.identityDelete");
    }
  }

  public class SuccessfulRead extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulRead;

    private Set<AttackStep> _cacheParentSuccessfulRead;

    public SuccessfulRead(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulRead == null) {
        _cacheChildrenSuccessfulRead = new HashSet<>();
        _cacheChildrenSuccessfulRead.add(read);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulRead == null) {
        _cacheParentSuccessfulRead = new HashSet<>();
        _cacheParentSuccessfulRead.add(accessDecryptedData);
        _cacheParentSuccessfulRead.add(dataNotPresent.disable);
        _cacheParentSuccessfulRead.add(attemptRead);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.successfulRead");
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
        for (Data _0 : containedData) {
          _cacheChildrenRead.add(_0.attemptRead);
        }
        _cacheChildrenRead.add(readContainedInformation);
        for (Information _1 : replicatedInformation) {
          _cacheChildrenRead.add(_1.read);
        }
        _cacheChildrenRead.add(extract);
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
        for (Information _2 : replicatedInformation) {
          _cacheParentRead.add(_2.read);
        }
        _cacheParentRead.add(successfulRead);
      }
      for (AttackStep attackStep : _cacheParentRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.read");
    }
  }

  public class SuccessfulWrite extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulWrite;

    private Set<AttackStep> _cacheParentSuccessfulWrite;

    public SuccessfulWrite(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulWrite == null) {
        _cacheChildrenSuccessfulWrite = new HashSet<>();
        for (Information _0 : replicatedInformation) {
          _cacheChildrenSuccessfulWrite.add(_0.write);
        }
        _cacheChildrenSuccessfulWrite.add(write);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulWrite) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulWrite == null) {
        _cacheParentSuccessfulWrite = new HashSet<>();
        Set<Data> _1 = new HashSet<>();
        List<Data> _2 = new ArrayList<>();
        _1.add(Data.this);
        _2.add(Data.this);
        while (!_2.isEmpty()) {
          Data _3 = _2.remove(0);
          for (Data _4 : _3.containingData) {
            if (!_1.contains(_4)) {
              _1.add(_4);
              _2.add(_4);
            }
          }
        }
        for (Data _5 : _1) {
          _cacheParentSuccessfulWrite.add(_5.accessSpoofedData);
        }
        _cacheParentSuccessfulWrite.add(accessDecryptedData);
        _cacheParentSuccessfulWrite.add(dataNotPresent.disable);
        _cacheParentSuccessfulWrite.add(attemptWrite);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulWrite) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.successfulWrite");
    }
  }

  public class Write extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenWrite;

    private Set<AttackStep> _cacheParentWrite;

    public Write(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenWrite == null) {
        _cacheChildrenWrite = new HashSet<>();
        for (Data _0 : containedData) {
          _cacheChildrenWrite.add(_0.attemptWrite);
        }
        _cacheChildrenWrite.add(attemptDelete);
        _cacheChildrenWrite.add(compromiseAppOrigin);
      }
      for (AttackStep attackStep : _cacheChildrenWrite) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentWrite == null) {
        _cacheParentWrite = new HashSet<>();
        _cacheParentWrite.add(successfulWrite);
      }
      for (AttackStep attackStep : _cacheParentWrite) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.write");
    }
  }

  public class SuccessfulDelete extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulDelete;

    private Set<AttackStep> _cacheParentSuccessfulDelete;

    public SuccessfulDelete(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulDelete == null) {
        _cacheChildrenSuccessfulDelete = new HashSet<>();
        for (Information _0 : replicatedInformation) {
          _cacheChildrenSuccessfulDelete.add(_0.delete);
        }
        _cacheChildrenSuccessfulDelete.add(delete);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulDelete) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulDelete == null) {
        _cacheParentSuccessfulDelete = new HashSet<>();
        _cacheParentSuccessfulDelete.add(accessDecryptedData);
        _cacheParentSuccessfulDelete.add(dataNotPresent.disable);
        _cacheParentSuccessfulDelete.add(attemptDelete);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulDelete) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.successfulDelete");
    }
  }

  public class Delete extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDelete;

    private Set<AttackStep> _cacheParentDelete;

    public Delete(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDelete == null) {
        _cacheChildrenDelete = new HashSet<>();
        for (Data _0 : containedData) {
          _cacheChildrenDelete.add(_0.attemptDelete);
        }
        _cacheChildrenDelete.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheChildrenDelete) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDelete == null) {
        _cacheParentDelete = new HashSet<>();
        _cacheParentDelete.add(successfulDelete);
      }
      for (AttackStep attackStep : _cacheParentDelete) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.delete");
    }
  }

  public class AttemptDeny extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDeny;

    private Set<AttackStep> _cacheParentAttemptDeny;

    public AttemptDeny(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDeny == null) {
        _cacheChildrenAttemptDeny = new HashSet<>();
        _cacheChildrenAttemptDeny.add(successfulDeny);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDeny) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDeny == null) {
        _cacheParentAttemptDeny = new HashSet<>();
        if (hardware != null) {
          _cacheParentAttemptDeny.add(hardware.deny);
        }
        for (Application _0 : containingApp) {
          _cacheParentAttemptDeny.add(_0.deny);
        }
        _cacheParentAttemptDeny.add(delete);
        for (Data _1 : containingData) {
          _cacheParentAttemptDeny.add(_1.deny);
        }
        _cacheParentAttemptDeny.add(denyDataInTransit);
      }
      for (AttackStep attackStep : _cacheParentAttemptDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptDeny");
    }
  }

  public class SuccessfulDeny extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulDeny;

    private Set<AttackStep> _cacheParentSuccessfulDeny;

    public SuccessfulDeny(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulDeny == null) {
        _cacheChildrenSuccessfulDeny = new HashSet<>();
        for (Information _0 : replicatedInformation) {
          _cacheChildrenSuccessfulDeny.add(_0.deny);
        }
        _cacheChildrenSuccessfulDeny.add(deny);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulDeny) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulDeny == null) {
        _cacheParentSuccessfulDeny = new HashSet<>();
        _cacheParentSuccessfulDeny.add(dataNotPresent.disable);
        _cacheParentSuccessfulDeny.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.successfulDeny");
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
        for (Data _0 : containedData) {
          _cacheChildrenDeny.add(_0.attemptDeny);
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
        _cacheParentDeny.add(successfulDeny);
      }
      for (AttackStep attackStep : _cacheParentDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.deny");
    }
  }

  public class AttemptWriteDataInTransitFromApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptWriteDataInTransitFromApplication;

    private Set<AttackStep> _cacheParentAttemptWriteDataInTransitFromApplication;

    public AttemptWriteDataInTransitFromApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptWriteDataInTransitFromApplication == null) {
        _cacheChildrenAttemptWriteDataInTransitFromApplication = new HashSet<>();
        _cacheChildrenAttemptWriteDataInTransitFromApplication.add(writeDataInTransit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptWriteDataInTransitFromApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptWriteDataInTransitFromApplication == null) {
        _cacheParentAttemptWriteDataInTransitFromApplication = new HashSet<>();
        for (Application _0 : senderApp) {
          _cacheParentAttemptWriteDataInTransitFromApplication.add(_0.fullAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptWriteDataInTransitFromApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptWriteDataInTransitFromApplication");
    }
  }

  public class AttemptIdentityWriteDataInTransitFromApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptIdentityWriteDataInTransitFromApplication;

    private Set<AttackStep> _cacheParentAttemptIdentityWriteDataInTransitFromApplication;

    public AttemptIdentityWriteDataInTransitFromApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptIdentityWriteDataInTransitFromApplication == null) {
        _cacheChildrenAttemptIdentityWriteDataInTransitFromApplication = new HashSet<>();
        _cacheChildrenAttemptIdentityWriteDataInTransitFromApplication.add(identityWriteDataInTransit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptIdentityWriteDataInTransitFromApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptIdentityWriteDataInTransitFromApplication == null) {
        _cacheParentAttemptIdentityWriteDataInTransitFromApplication = new HashSet<>();
        for (Application _0 : senderApp) {
          _cacheParentAttemptIdentityWriteDataInTransitFromApplication.add(_0.specificAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptIdentityWriteDataInTransitFromApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptIdentityWriteDataInTransitFromApplication");
    }
  }

  public class AttemptWriteDataInTransitFromConnectionRule extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptWriteDataInTransitFromConnectionRule;

    private Set<AttackStep> _cacheParentAttemptWriteDataInTransitFromConnectionRule;

    public AttemptWriteDataInTransitFromConnectionRule(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptWriteDataInTransitFromConnectionRule == null) {
        _cacheChildrenAttemptWriteDataInTransitFromConnectionRule = new HashSet<>();
        _cacheChildrenAttemptWriteDataInTransitFromConnectionRule.add(writeDataInTransit);
        _cacheChildrenAttemptWriteDataInTransitFromConnectionRule.add(identityWriteDataInTransit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptWriteDataInTransitFromConnectionRule) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptWriteDataInTransitFromConnectionRule == null) {
        _cacheParentAttemptWriteDataInTransitFromConnectionRule = new HashSet<>();
        for (Network _0 : transitNetwork) {
          Set<ConnectionRule> _1 = new HashSet<>();
          Set<ConnectionRule> _2 = new HashSet<>();
          for (ConnectionRule _3 : _0.diodeIngoingNetConnections) {
            _1.add(_3);
          }
          Set<ConnectionRule> _4 = new HashSet<>();
          Set<ConnectionRule> _5 = new HashSet<>();
          for (ConnectionRule _6 : _0.ingoingNetConnections) {
            _4.add(_6);
          }
          for (ConnectionRule _7 : _0.netConnections) {
            _5.add(_7);
          }
          _4.addAll(_5);
          for (ConnectionRule _8 : _4) {
            _2.add(_8);
          }
          _1.addAll(_2);
          for (ConnectionRule _9 : _1) {
            _cacheParentAttemptWriteDataInTransitFromConnectionRule.add(_9.allowWriteDataInTransit);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptWriteDataInTransitFromConnectionRule) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptWriteDataInTransitFromConnectionRule");
    }
  }

  public class IdentityWriteDataInTransit extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenIdentityWriteDataInTransit;

    private Set<AttackStep> _cacheParentIdentityWriteDataInTransit;

    public IdentityWriteDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenIdentityWriteDataInTransit == null) {
        _cacheChildrenIdentityWriteDataInTransit = new HashSet<>();
        _cacheChildrenIdentityWriteDataInTransit.add(identityAttemptWrite);
      }
      for (AttackStep attackStep : _cacheChildrenIdentityWriteDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentIdentityWriteDataInTransit == null) {
        _cacheParentIdentityWriteDataInTransit = new HashSet<>();
        _cacheParentIdentityWriteDataInTransit.add(attemptIdentityWriteDataInTransitFromApplication);
        _cacheParentIdentityWriteDataInTransit.add(attemptWriteDataInTransitFromConnectionRule);
      }
      for (AttackStep attackStep : _cacheParentIdentityWriteDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.identityWriteDataInTransit");
    }
  }

  public class WriteDataInTransit extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenWriteDataInTransit;

    private Set<AttackStep> _cacheParentWriteDataInTransit;

    public WriteDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenWriteDataInTransit == null) {
        _cacheChildrenWriteDataInTransit = new HashSet<>();
        _cacheChildrenWriteDataInTransit.add(attemptWrite);
      }
      for (AttackStep attackStep : _cacheChildrenWriteDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentWriteDataInTransit == null) {
        _cacheParentWriteDataInTransit = new HashSet<>();
        _cacheParentWriteDataInTransit.add(attemptWriteDataInTransitFromApplication);
        _cacheParentWriteDataInTransit.add(attemptWriteDataInTransitFromConnectionRule);
      }
      for (AttackStep attackStep : _cacheParentWriteDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.writeDataInTransit");
    }
  }

  public class AttemptDenyDataInTransitFromApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDenyDataInTransitFromApplication;

    private Set<AttackStep> _cacheParentAttemptDenyDataInTransitFromApplication;

    public AttemptDenyDataInTransitFromApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDenyDataInTransitFromApplication == null) {
        _cacheChildrenAttemptDenyDataInTransitFromApplication = new HashSet<>();
        _cacheChildrenAttemptDenyDataInTransitFromApplication.add(denyDataInTransit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDenyDataInTransitFromApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDenyDataInTransitFromApplication == null) {
        _cacheParentAttemptDenyDataInTransitFromApplication = new HashSet<>();
        for (Application _0 : senderApp) {
          _cacheParentAttemptDenyDataInTransitFromApplication.add(_0.deny);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDenyDataInTransitFromApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptDenyDataInTransitFromApplication");
    }
  }

  public class AttemptDenyDataInTransitFromConnectionRule extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDenyDataInTransitFromConnectionRule;

    private Set<AttackStep> _cacheParentAttemptDenyDataInTransitFromConnectionRule;

    public AttemptDenyDataInTransitFromConnectionRule(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDenyDataInTransitFromConnectionRule == null) {
        _cacheChildrenAttemptDenyDataInTransitFromConnectionRule = new HashSet<>();
        _cacheChildrenAttemptDenyDataInTransitFromConnectionRule.add(denyDataInTransit);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDenyDataInTransitFromConnectionRule) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDenyDataInTransitFromConnectionRule == null) {
        _cacheParentAttemptDenyDataInTransitFromConnectionRule = new HashSet<>();
        for (Network _0 : transitNetwork) {
          Set<ConnectionRule> _1 = new HashSet<>();
          Set<ConnectionRule> _2 = new HashSet<>();
          for (ConnectionRule _3 : _0.diodeIngoingNetConnections) {
            _1.add(_3);
          }
          Set<ConnectionRule> _4 = new HashSet<>();
          Set<ConnectionRule> _5 = new HashSet<>();
          for (ConnectionRule _6 : _0.ingoingNetConnections) {
            _4.add(_6);
          }
          for (ConnectionRule _7 : _0.netConnections) {
            _5.add(_7);
          }
          _4.addAll(_5);
          for (ConnectionRule _8 : _4) {
            _2.add(_8);
          }
          _1.addAll(_2);
          for (ConnectionRule _9 : _1) {
            _cacheParentAttemptDenyDataInTransitFromConnectionRule.add(_9.allowDenyDataInTransit);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDenyDataInTransitFromConnectionRule) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptDenyDataInTransitFromConnectionRule");
    }
  }

  public class DenyDataInTransit extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDenyDataInTransit;

    private Set<AttackStep> _cacheParentDenyDataInTransit;

    public DenyDataInTransit(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyDataInTransit == null) {
        _cacheChildrenDenyDataInTransit = new HashSet<>();
        _cacheChildrenDenyDataInTransit.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheChildrenDenyDataInTransit) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyDataInTransit == null) {
        _cacheParentDenyDataInTransit = new HashSet<>();
        _cacheParentDenyDataInTransit.add(attemptDenyDataInTransitFromApplication);
        _cacheParentDenyDataInTransit.add(attemptDenyDataInTransitFromConnectionRule);
      }
      for (AttackStep attackStep : _cacheParentDenyDataInTransit) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.denyDataInTransit");
    }
  }

  public class AttemptReverseReach extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptReverseReach;

    private Set<AttackStep> _cacheParentAttemptReverseReach;

    public AttemptReverseReach(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptReverseReach == null) {
        _cacheChildrenAttemptReverseReach = new HashSet<>();
        _cacheChildrenAttemptReverseReach.add(reverseReach);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptReverseReach) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptReverseReach == null) {
        _cacheParentAttemptReverseReach = new HashSet<>();
        for (Application _0 : containingApp) {
          _cacheParentAttemptReverseReach.add(_0.reverseReach);
        }
        for (Application _1 : senderApp) {
          _cacheParentAttemptReverseReach.add(_1.reverseReach);
        }
        for (Application _2 : receiverApp) {
          _cacheParentAttemptReverseReach.add(_2.reverseReach);
        }
        for (Data _3 : containingData) {
          _cacheParentAttemptReverseReach.add(_3.reverseReach);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.attemptReverseReach");
    }
  }

  public class ReverseReach extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenReverseReach;

    private Set<AttackStep> _cacheParentReverseReach;

    public ReverseReach(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReverseReach == null) {
        _cacheChildrenReverseReach = new HashSet<>();
        _cacheChildrenReverseReach.add(extract);
        for (Data _0 : containedData) {
          _cacheChildrenReverseReach.add(_0.attemptReverseReach);
        }
      }
      for (AttackStep attackStep : _cacheChildrenReverseReach) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReverseReach == null) {
        _cacheParentReverseReach = new HashSet<>();
        _cacheParentReverseReach.add(attemptReverseReach);
      }
      for (AttackStep attackStep : _cacheParentReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.reverseReach");
    }
  }

  public class Extract extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenExtract;

    private Set<AttackStep> _cacheParentExtract;

    public Extract(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenExtract == null) {
        _cacheChildrenExtract = new HashSet<>();
        for (Information _0 : information) {
          _cacheChildrenExtract.add(_0.read);
        }
      }
      for (AttackStep attackStep : _cacheChildrenExtract) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentExtract == null) {
        _cacheParentExtract = new HashSet<>();
        _cacheParentExtract.add(read);
        _cacheParentExtract.add(reverseReach);
      }
      for (AttackStep attackStep : _cacheParentExtract) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.extract");
    }
  }

  public class CompromiseAppOrigin extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenCompromiseAppOrigin;

    private Set<AttackStep> _cacheParentCompromiseAppOrigin;

    public CompromiseAppOrigin(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenCompromiseAppOrigin == null) {
        _cacheChildrenCompromiseAppOrigin = new HashSet<>();
        if (originSoftwareProduct != null) {
          _cacheChildrenCompromiseAppOrigin.add(originSoftwareProduct.compromiseApplication);
        }
      }
      for (AttackStep attackStep : _cacheChildrenCompromiseAppOrigin) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentCompromiseAppOrigin == null) {
        _cacheParentCompromiseAppOrigin = new HashSet<>();
        _cacheParentCompromiseAppOrigin.add(write);
      }
      for (AttackStep attackStep : _cacheParentCompromiseAppOrigin) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.compromiseAppOrigin");
    }
  }
}
