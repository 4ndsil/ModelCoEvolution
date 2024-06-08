package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Data extends Asset {
  public NotPresent notPresent;

  public AuthorizedAccessFromApplication authorizedAccessFromApplication;

  public DataEncrypted dataEncrypted;

  public DataSigned dataSigned;

  public PayloadInspectionBypassFromEncryptedData payloadInspectionBypassFromEncryptedData;

  public BypassPayloadInspectionFromEncryptedData bypassPayloadInspectionFromEncryptedData;

  public AccessUnencryptedData accessUnencryptedData;

  public AccessUnsignedData accessUnsignedData;

  public AccessSpoofedData accessSpoofedData;

  public AccessDecryptedData accessDecryptedData;

  public AttemptApplicationRespondConnect attemptApplicationRespondConnect;

  public ApplicationRespondConnect applicationRespondConnect;

  public AuthorizedApplicationRespondConnectFromApplication authorizedApplicationRespondConnectFromApplication;

  public AuthorizedApplicationRespondConnectFromIAM authorizedApplicationRespondConnectFromIAM;

  public AuthorizedApplicationRespondConnect authorizedApplicationRespondConnect;

  public AttemptRead attemptRead;

  public SuccessfulRead successfulRead;

  public Read read;

  public AuthorizedReadFromIAM authorizedReadFromIAM;

  public AuthorizedReadFromApplication authorizedReadFromApplication;

  public AuthorizedRead authorizedRead;

  public AttemptWrite attemptWrite;

  public SuccessfulWrite successfulWrite;

  public Write write;

  public AuthorizedWriteFromIAM authorizedWriteFromIAM;

  public AuthorizedWriteFromApplication authorizedWriteFromApplication;

  public AuthorizedWrite authorizedWrite;

  public AttemptDelete attemptDelete;

  public SuccessfulDelete successfulDelete;

  public Delete delete;

  public AuthorizedDeleteFromIAM authorizedDeleteFromIAM;

  public AuthorizedDeleteFromApplication authorizedDeleteFromApplication;

  public AuthorizedDelete authorizedDelete;

  public AttemptDeny attemptDeny;

  public SuccessfulDeny successfulDeny;

  public Deny deny;

  public DenyFromLockout denyFromLockout;

  public AttemptReverseReach attemptReverseReach;

  public ReverseReach reverseReach;

  public Extract extract;

  private Set<ConnectionRule> _cachesenderOutgoingApplicationConnectionsData;

  private Set<ConnectionRule> _cachetransitNetworkInboundAllowedConnectionsData;

  private Set<ConnectionRule> _cachereceiverIngoingApplicationConnectionsData;

  private Set<ConnectionRule> _cachetransitNetworkOutboundAllowedConnectionsData;

  public Set<Data> containedData = new HashSet<>();

  public Set<Data> containingData = new HashSet<>();

  public Set<Application> containingApp = new HashSet<>();

  public Set<Application> senderApp = new HashSet<>();

  public Set<Application> receiverApp = new HashSet<>();

  public Set<Network> transitNetwork = new HashSet<>();

  public Hardware hardware = null;

  public Set<Information> information = new HashSet<>();

  public Set<Information> replicatedInformation = new HashSet<>();

  public Set<Application> dependentApps = new HashSet<>();

  public Credentials encryptCreds = null;

  public Credentials signingCreds = null;

  public Set<IAMObject> readingIAMs = new HashSet<>();

  public Set<IAMObject> writingIAMs = new HashSet<>();

  public Set<IAMObject> deletingIAMs = new HashSet<>();

  public Data(String name, boolean isNotPresentEnabled) {
    super(name);
    assetClassName = "Data";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, isNotPresentEnabled);
    AttackStep.allAttackSteps.remove(authorizedAccessFromApplication);
    authorizedAccessFromApplication = new AuthorizedAccessFromApplication(name);
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
    if (payloadInspectionBypassFromEncryptedData != null) {
      AttackStep.allAttackSteps.remove(payloadInspectionBypassFromEncryptedData.disable);
    }
    Defense.allDefenses.remove(payloadInspectionBypassFromEncryptedData);
    payloadInspectionBypassFromEncryptedData = new PayloadInspectionBypassFromEncryptedData(name);
    AttackStep.allAttackSteps.remove(bypassPayloadInspectionFromEncryptedData);
    bypassPayloadInspectionFromEncryptedData = new BypassPayloadInspectionFromEncryptedData(name);
    AttackStep.allAttackSteps.remove(accessUnencryptedData);
    accessUnencryptedData = new AccessUnencryptedData(name);
    AttackStep.allAttackSteps.remove(accessUnsignedData);
    accessUnsignedData = new AccessUnsignedData(name);
    AttackStep.allAttackSteps.remove(accessSpoofedData);
    accessSpoofedData = new AccessSpoofedData(name);
    AttackStep.allAttackSteps.remove(accessDecryptedData);
    accessDecryptedData = new AccessDecryptedData(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnect);
    attemptApplicationRespondConnect = new AttemptApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(applicationRespondConnect);
    applicationRespondConnect = new ApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(authorizedApplicationRespondConnectFromApplication);
    authorizedApplicationRespondConnectFromApplication = new AuthorizedApplicationRespondConnectFromApplication(name);
    AttackStep.allAttackSteps.remove(authorizedApplicationRespondConnectFromIAM);
    authorizedApplicationRespondConnectFromIAM = new AuthorizedApplicationRespondConnectFromIAM(name);
    AttackStep.allAttackSteps.remove(authorizedApplicationRespondConnect);
    authorizedApplicationRespondConnect = new AuthorizedApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(attemptRead);
    attemptRead = new AttemptRead(name);
    AttackStep.allAttackSteps.remove(successfulRead);
    successfulRead = new SuccessfulRead(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(authorizedReadFromIAM);
    authorizedReadFromIAM = new AuthorizedReadFromIAM(name);
    AttackStep.allAttackSteps.remove(authorizedReadFromApplication);
    authorizedReadFromApplication = new AuthorizedReadFromApplication(name);
    AttackStep.allAttackSteps.remove(authorizedRead);
    authorizedRead = new AuthorizedRead(name);
    AttackStep.allAttackSteps.remove(attemptWrite);
    attemptWrite = new AttemptWrite(name);
    AttackStep.allAttackSteps.remove(successfulWrite);
    successfulWrite = new SuccessfulWrite(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
    AttackStep.allAttackSteps.remove(authorizedWriteFromIAM);
    authorizedWriteFromIAM = new AuthorizedWriteFromIAM(name);
    AttackStep.allAttackSteps.remove(authorizedWriteFromApplication);
    authorizedWriteFromApplication = new AuthorizedWriteFromApplication(name);
    AttackStep.allAttackSteps.remove(authorizedWrite);
    authorizedWrite = new AuthorizedWrite(name);
    AttackStep.allAttackSteps.remove(attemptDelete);
    attemptDelete = new AttemptDelete(name);
    AttackStep.allAttackSteps.remove(successfulDelete);
    successfulDelete = new SuccessfulDelete(name);
    AttackStep.allAttackSteps.remove(delete);
    delete = new Delete(name);
    AttackStep.allAttackSteps.remove(authorizedDeleteFromIAM);
    authorizedDeleteFromIAM = new AuthorizedDeleteFromIAM(name);
    AttackStep.allAttackSteps.remove(authorizedDeleteFromApplication);
    authorizedDeleteFromApplication = new AuthorizedDeleteFromApplication(name);
    AttackStep.allAttackSteps.remove(authorizedDelete);
    authorizedDelete = new AuthorizedDelete(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(successfulDeny);
    successfulDeny = new SuccessfulDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(denyFromLockout);
    denyFromLockout = new DenyFromLockout(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(extract);
    extract = new Extract(name);
  }

  public Data(String name) {
    super(name);
    assetClassName = "Data";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, false);
    AttackStep.allAttackSteps.remove(authorizedAccessFromApplication);
    authorizedAccessFromApplication = new AuthorizedAccessFromApplication(name);
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
    if (payloadInspectionBypassFromEncryptedData != null) {
      AttackStep.allAttackSteps.remove(payloadInspectionBypassFromEncryptedData.disable);
    }
    Defense.allDefenses.remove(payloadInspectionBypassFromEncryptedData);
    payloadInspectionBypassFromEncryptedData = new PayloadInspectionBypassFromEncryptedData(name);
    AttackStep.allAttackSteps.remove(bypassPayloadInspectionFromEncryptedData);
    bypassPayloadInspectionFromEncryptedData = new BypassPayloadInspectionFromEncryptedData(name);
    AttackStep.allAttackSteps.remove(accessUnencryptedData);
    accessUnencryptedData = new AccessUnencryptedData(name);
    AttackStep.allAttackSteps.remove(accessUnsignedData);
    accessUnsignedData = new AccessUnsignedData(name);
    AttackStep.allAttackSteps.remove(accessSpoofedData);
    accessSpoofedData = new AccessSpoofedData(name);
    AttackStep.allAttackSteps.remove(accessDecryptedData);
    accessDecryptedData = new AccessDecryptedData(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnect);
    attemptApplicationRespondConnect = new AttemptApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(applicationRespondConnect);
    applicationRespondConnect = new ApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(authorizedApplicationRespondConnectFromApplication);
    authorizedApplicationRespondConnectFromApplication = new AuthorizedApplicationRespondConnectFromApplication(name);
    AttackStep.allAttackSteps.remove(authorizedApplicationRespondConnectFromIAM);
    authorizedApplicationRespondConnectFromIAM = new AuthorizedApplicationRespondConnectFromIAM(name);
    AttackStep.allAttackSteps.remove(authorizedApplicationRespondConnect);
    authorizedApplicationRespondConnect = new AuthorizedApplicationRespondConnect(name);
    AttackStep.allAttackSteps.remove(attemptRead);
    attemptRead = new AttemptRead(name);
    AttackStep.allAttackSteps.remove(successfulRead);
    successfulRead = new SuccessfulRead(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(authorizedReadFromIAM);
    authorizedReadFromIAM = new AuthorizedReadFromIAM(name);
    AttackStep.allAttackSteps.remove(authorizedReadFromApplication);
    authorizedReadFromApplication = new AuthorizedReadFromApplication(name);
    AttackStep.allAttackSteps.remove(authorizedRead);
    authorizedRead = new AuthorizedRead(name);
    AttackStep.allAttackSteps.remove(attemptWrite);
    attemptWrite = new AttemptWrite(name);
    AttackStep.allAttackSteps.remove(successfulWrite);
    successfulWrite = new SuccessfulWrite(name);
    AttackStep.allAttackSteps.remove(write);
    write = new Write(name);
    AttackStep.allAttackSteps.remove(authorizedWriteFromIAM);
    authorizedWriteFromIAM = new AuthorizedWriteFromIAM(name);
    AttackStep.allAttackSteps.remove(authorizedWriteFromApplication);
    authorizedWriteFromApplication = new AuthorizedWriteFromApplication(name);
    AttackStep.allAttackSteps.remove(authorizedWrite);
    authorizedWrite = new AuthorizedWrite(name);
    AttackStep.allAttackSteps.remove(attemptDelete);
    attemptDelete = new AttemptDelete(name);
    AttackStep.allAttackSteps.remove(successfulDelete);
    successfulDelete = new SuccessfulDelete(name);
    AttackStep.allAttackSteps.remove(delete);
    delete = new Delete(name);
    AttackStep.allAttackSteps.remove(authorizedDeleteFromIAM);
    authorizedDeleteFromIAM = new AuthorizedDeleteFromIAM(name);
    AttackStep.allAttackSteps.remove(authorizedDeleteFromApplication);
    authorizedDeleteFromApplication = new AuthorizedDeleteFromApplication(name);
    AttackStep.allAttackSteps.remove(authorizedDelete);
    authorizedDelete = new AuthorizedDelete(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(successfulDeny);
    successfulDeny = new SuccessfulDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(denyFromLockout);
    denyFromLockout = new DenyFromLockout(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(extract);
    extract = new Extract(name);
  }

  public Data(boolean isNotPresentEnabled) {
    this("Anonymous", isNotPresentEnabled);
  }

  public Data() {
    this("Anonymous");
  }

  protected Set<ConnectionRule> _senderOutgoingApplicationConnectionsData() {
    if (_cachesenderOutgoingApplicationConnectionsData == null) {
      _cachesenderOutgoingApplicationConnectionsData = new HashSet<>();
      Set<ConnectionRule> _2 = new HashSet<>();
      Set<ConnectionRule> _3 = new HashSet<>();
      for (Application _4 : senderApp) {
        for (ConnectionRule _5 : _4.appConnections) {
          _2.add(_5);
        }
      }
      for (Application _6 : senderApp) {
        for (ConnectionRule _7 : _6.outgoingAppConnections) {
          _3.add(_7);
        }
      }
      _2.addAll(_3);
      for (ConnectionRule _8 : _2) {
        _cachesenderOutgoingApplicationConnectionsData.add(_8);
      }
    }
    return _cachesenderOutgoingApplicationConnectionsData;
  }

  protected Set<ConnectionRule> _transitNetworkInboundAllowedConnectionsData() {
    if (_cachetransitNetworkInboundAllowedConnectionsData == null) {
      _cachetransitNetworkInboundAllowedConnectionsData = new HashSet<>();
      Set<ConnectionRule> _9 = new HashSet<>();
      Set<ConnectionRule> _a = new HashSet<>();
      Set<ConnectionRule> _b = new HashSet<>();
      Set<ConnectionRule> _c = new HashSet<>();
      for (Network _d : transitNetwork) {
        for (ConnectionRule _e : _d.netConnections) {
          _b.add(_e);
        }
      }
      for (Network _f : transitNetwork) {
        for (ConnectionRule _10 : _f.ingoingNetConnections) {
          _c.add(_10);
        }
      }
      _b.addAll(_c);
      for (ConnectionRule _11 : _b) {
        _9.add(_11);
      }
      for (Network _12 : transitNetwork) {
        for (ConnectionRule _13 : _12.diodeIngoingNetConnections) {
          _a.add(_13);
        }
      }
      _9.addAll(_a);
      for (ConnectionRule _14 : _9) {
        _cachetransitNetworkInboundAllowedConnectionsData.add(_14);
      }
    }
    return _cachetransitNetworkInboundAllowedConnectionsData;
  }

  protected Set<ConnectionRule> _receiverIngoingApplicationConnectionsData() {
    if (_cachereceiverIngoingApplicationConnectionsData == null) {
      _cachereceiverIngoingApplicationConnectionsData = new HashSet<>();
      Set<ConnectionRule> _15 = new HashSet<>();
      Set<ConnectionRule> _16 = new HashSet<>();
      for (Application _17 : receiverApp) {
        for (ConnectionRule _18 : _17.appConnections) {
          _15.add(_18);
        }
      }
      for (Application _19 : receiverApp) {
        for (ConnectionRule _1a : _19.ingoingAppConnections) {
          _16.add(_1a);
        }
      }
      _15.addAll(_16);
      for (ConnectionRule _1b : _15) {
        _cachereceiverIngoingApplicationConnectionsData.add(_1b);
      }
    }
    return _cachereceiverIngoingApplicationConnectionsData;
  }

  protected Set<ConnectionRule> _transitNetworkOutboundAllowedConnectionsData() {
    if (_cachetransitNetworkOutboundAllowedConnectionsData == null) {
      _cachetransitNetworkOutboundAllowedConnectionsData = new HashSet<>();
      Set<ConnectionRule> _1c = new HashSet<>();
      Set<ConnectionRule> _1d = new HashSet<>();
      for (Network _1e : transitNetwork) {
        for (ConnectionRule _1f : _1e.netConnections) {
          _1c.add(_1f);
        }
      }
      for (Network _20 : transitNetwork) {
        for (ConnectionRule _21 : _20.outgoingNetConnections) {
          _1d.add(_21);
        }
      }
      _1c.addAll(_1d);
      for (ConnectionRule _22 : _1c) {
        _cachetransitNetworkOutboundAllowedConnectionsData.add(_22);
      }
    }
    return _cachetransitNetworkOutboundAllowedConnectionsData;
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

  public void addDependentApps(Application dependentApps) {
    this.dependentApps.add(dependentApps);
    dependentApps.dataDependedUpon.add(this);
  }

  public void addEncryptCreds(Credentials encryptCreds) {
    this.encryptCreds = encryptCreds;
    encryptCreds.encryptedData.add(this);
  }

  public void addSigningCreds(Credentials signingCreds) {
    this.signingCreds = signingCreds;
    signingCreds.signedData.add(this);
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
    } else if (field.equals("dependentApps")) {
      return Application.class.getName();
    } else if (field.equals("encryptCreds")) {
      return Credentials.class.getName();
    } else if (field.equals("signingCreds")) {
      return Credentials.class.getName();
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
    } else if (field.equals("dependentApps")) {
      assets.addAll(dependentApps);
    } else if (field.equals("encryptCreds")) {
      if (encryptCreds != null) {
        assets.add(encryptCreds);
      }
    } else if (field.equals("signingCreds")) {
      if (signingCreds != null) {
        assets.add(signingCreds);
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
    assets.addAll(dependentApps);
    if (encryptCreds != null) {
      assets.add(encryptCreds);
    }
    if (signingCreds != null) {
      assets.add(signingCreds);
    }
    assets.addAll(readingIAMs);
    assets.addAll(writingIAMs);
    assets.addAll(deletingIAMs);
    return assets;
  }

  public class NotPresent extends Defense {
    public NotPresent(String name) {
      this(name, false);
    }

    public NotPresent(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNotPresent;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNotPresent == null) {
          _cacheChildrenNotPresent = new HashSet<>();
          _cacheChildrenNotPresent.add(applicationRespondConnect);
          _cacheChildrenNotPresent.add(successfulRead);
          _cacheChildrenNotPresent.add(successfulWrite);
          _cacheChildrenNotPresent.add(successfulDeny);
          _cacheChildrenNotPresent.add(successfulDelete);
          _cacheChildrenNotPresent.add(reverseReach);
          _cacheChildrenNotPresent.add(extract);
        }
        for (AttackStep attackStep : _cacheChildrenNotPresent) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Data.notPresent";
      }
    }
  }

  public class AuthorizedAccessFromApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedAccessFromApplication;

    public AuthorizedAccessFromApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedAccessFromApplication == null) {
        _cacheChildrenAuthorizedAccessFromApplication = new HashSet<>();
        _cacheChildrenAuthorizedAccessFromApplication.add(authorizedReadFromApplication);
        _cacheChildrenAuthorizedAccessFromApplication.add(authorizedWriteFromApplication);
        _cacheChildrenAuthorizedAccessFromApplication.add(authorizedDeleteFromApplication);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedAccessFromApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedAccessFromApplication");
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

  public class PayloadInspectionBypassFromEncryptedData extends Defense {
    public PayloadInspectionBypassFromEncryptedData(String name) {
      super(name);
      disable = new Disable(name);
    }

    @Override
    public boolean isEnabled() {
      if (encryptCreds != null) {
        return false;
      }
      return true;
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenPayloadInspectionBypassFromEncryptedData;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenPayloadInspectionBypassFromEncryptedData == null) {
          _cacheChildrenPayloadInspectionBypassFromEncryptedData = new HashSet<>();
          _cacheChildrenPayloadInspectionBypassFromEncryptedData.add(bypassPayloadInspectionFromEncryptedData);
        }
        for (AttackStep attackStep : _cacheChildrenPayloadInspectionBypassFromEncryptedData) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Data.payloadInspectionBypassFromEncryptedData";
      }
    }
  }

  public class BypassPayloadInspectionFromEncryptedData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassPayloadInspectionFromEncryptedData;

    private Set<AttackStep> _cacheParentBypassPayloadInspectionFromEncryptedData;

    public BypassPayloadInspectionFromEncryptedData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassPayloadInspectionFromEncryptedData == null) {
        _cacheChildrenBypassPayloadInspectionFromEncryptedData = new HashSet<>();
        Set<ConnectionRule> _0 = new HashSet<>();
        Set<ConnectionRule> _1 = new HashSet<>();
        for (var _2 : _senderOutgoingApplicationConnectionsData()) {
          _0.add(_2);
        }
        for (var _3 : _transitNetworkInboundAllowedConnectionsData()) {
          _1.add(_3);
        }
        _0.retainAll(_1);
        for (ConnectionRule _4 : _0) {
          _cacheChildrenBypassPayloadInspectionFromEncryptedData.add(_4.payloadInspectionBypassed);
        }
        Set<ConnectionRule> _5 = new HashSet<>();
        Set<ConnectionRule> _6 = new HashSet<>();
        for (var _7 : _receiverIngoingApplicationConnectionsData()) {
          _5.add(_7);
        }
        for (var _8 : _transitNetworkOutboundAllowedConnectionsData()) {
          _6.add(_8);
        }
        _5.retainAll(_6);
        for (ConnectionRule _9 : _5) {
          _cacheChildrenBypassPayloadInspectionFromEncryptedData.add(_9.payloadInspectionBypassed);
        }
      }
      for (AttackStep attackStep : _cacheChildrenBypassPayloadInspectionFromEncryptedData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassPayloadInspectionFromEncryptedData == null) {
        _cacheParentBypassPayloadInspectionFromEncryptedData = new HashSet<>();
        _cacheParentBypassPayloadInspectionFromEncryptedData.add(payloadInspectionBypassFromEncryptedData.disable);
      }
      for (AttackStep attackStep : _cacheParentBypassPayloadInspectionFromEncryptedData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.bypassPayloadInspectionFromEncryptedData");
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
        _cacheChildrenAccessSpoofedData.add(applicationRespondConnect);
        _cacheChildrenAccessSpoofedData.add(successfulWrite);
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
        _cacheParentAttemptApplicationRespondConnect.add(authorizedApplicationRespondConnect);
        for (Network _1 : transitNetwork) {
          _cacheParentAttemptApplicationRespondConnect.add(_1.adversaryInTheMiddle);
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
          _cacheChildrenApplicationRespondConnect.add(_0.attemptNetworkConnectFromResponse);
        }
        for (Data _1 : containedData) {
          _cacheChildrenApplicationRespondConnect.add(_1.applicationRespondConnect);
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
        _cacheParentApplicationRespondConnect.add(notPresent.disable);
        _cacheParentApplicationRespondConnect.add(accessSpoofedData);
        _cacheParentApplicationRespondConnect.add(accessDecryptedData);
        _cacheParentApplicationRespondConnect.add(attemptApplicationRespondConnect);
        for (Data _2 : containingData) {
          _cacheParentApplicationRespondConnect.add(_2.applicationRespondConnect);
        }
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

  public class AuthorizedApplicationRespondConnectFromApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedApplicationRespondConnectFromApplication;

    private Set<AttackStep> _cacheParentAuthorizedApplicationRespondConnectFromApplication;

    public AuthorizedApplicationRespondConnectFromApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedApplicationRespondConnectFromApplication == null) {
        _cacheChildrenAuthorizedApplicationRespondConnectFromApplication = new HashSet<>();
        _cacheChildrenAuthorizedApplicationRespondConnectFromApplication.add(authorizedApplicationRespondConnect);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedApplicationRespondConnectFromApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedApplicationRespondConnectFromApplication == null) {
        _cacheParentAuthorizedApplicationRespondConnectFromApplication = new HashSet<>();
        for (Application _0 : receiverApp) {
          _cacheParentAuthorizedApplicationRespondConnectFromApplication.add(_0.authorizedApplicationRespondConnectThroughData);
        }
      }
      for (AttackStep attackStep : _cacheParentAuthorizedApplicationRespondConnectFromApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedApplicationRespondConnectFromApplication");
    }
  }

  public class AuthorizedApplicationRespondConnectFromIAM extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedApplicationRespondConnectFromIAM;

    private Set<AttackStep> _cacheParentAuthorizedApplicationRespondConnectFromIAM;

    public AuthorizedApplicationRespondConnectFromIAM(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedApplicationRespondConnectFromIAM == null) {
        _cacheChildrenAuthorizedApplicationRespondConnectFromIAM = new HashSet<>();
        _cacheChildrenAuthorizedApplicationRespondConnectFromIAM.add(authorizedApplicationRespondConnect);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedApplicationRespondConnectFromIAM) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedApplicationRespondConnectFromIAM == null) {
        _cacheParentAuthorizedApplicationRespondConnectFromIAM = new HashSet<>();
        for (IAMObject _0 : writingIAMs) {
          _cacheParentAuthorizedApplicationRespondConnectFromIAM.add(_0.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentAuthorizedApplicationRespondConnectFromIAM) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedApplicationRespondConnectFromIAM");
    }
  }

  public class AuthorizedApplicationRespondConnect extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAuthorizedApplicationRespondConnect;

    private Set<AttackStep> _cacheParentAuthorizedApplicationRespondConnect;

    public AuthorizedApplicationRespondConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedApplicationRespondConnect == null) {
        _cacheChildrenAuthorizedApplicationRespondConnect = new HashSet<>();
        _cacheChildrenAuthorizedApplicationRespondConnect.add(attemptApplicationRespondConnect);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedApplicationRespondConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedApplicationRespondConnect == null) {
        _cacheParentAuthorizedApplicationRespondConnect = new HashSet<>();
        _cacheParentAuthorizedApplicationRespondConnect.add(authorizedApplicationRespondConnectFromApplication);
        _cacheParentAuthorizedApplicationRespondConnect.add(authorizedApplicationRespondConnectFromIAM);
      }
      for (AttackStep attackStep : _cacheParentAuthorizedApplicationRespondConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedApplicationRespondConnect");
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
          _cacheParentAttemptRead.add(hardware.fullAccess);
        }
        if (hardware != null) {
          _cacheParentAttemptRead.add(hardware.read);
        }
        for (Application _0 : containingApp) {
          _cacheParentAttemptRead.add(_0.read);
        }
        for (Application _1 : senderApp) {
          _cacheParentAttemptRead.add(_1.read);
        }
        for (Application _2 : receiverApp) {
          _cacheParentAttemptRead.add(_2.read);
        }
        for (Data _3 : containingData) {
          _cacheParentAttemptRead.add(_3.read);
        }
        _cacheParentAttemptRead.add(authorizedRead);
        for (Network _4 : transitNetwork) {
          _cacheParentAttemptRead.add(_4.eavesdrop);
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
        _cacheParentSuccessfulRead.add(notPresent.disable);
        _cacheParentSuccessfulRead.add(accessDecryptedData);
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
        for (Information _1 : information) {
          _cacheChildrenRead.add(_1.read);
        }
        for (Information _2 : replicatedInformation) {
          _cacheChildrenRead.add(_2.attemptReadFromReplica);
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
        for (Information _3 : replicatedInformation) {
          _cacheParentRead.add(_3.read);
        }
        for (Information _4 : information) {
          _cacheParentRead.add(_4.read);
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

  public class AuthorizedReadFromIAM extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedReadFromIAM;

    private Set<AttackStep> _cacheParentAuthorizedReadFromIAM;

    public AuthorizedReadFromIAM(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedReadFromIAM == null) {
        _cacheChildrenAuthorizedReadFromIAM = new HashSet<>();
        _cacheChildrenAuthorizedReadFromIAM.add(authorizedRead);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedReadFromIAM) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedReadFromIAM == null) {
        _cacheParentAuthorizedReadFromIAM = new HashSet<>();
        for (IAMObject _0 : readingIAMs) {
          _cacheParentAuthorizedReadFromIAM.add(_0.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentAuthorizedReadFromIAM) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedReadFromIAM");
    }
  }

  public class AuthorizedReadFromApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedReadFromApplication;

    private Set<AttackStep> _cacheParentAuthorizedReadFromApplication;

    public AuthorizedReadFromApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedReadFromApplication == null) {
        _cacheChildrenAuthorizedReadFromApplication = new HashSet<>();
        _cacheChildrenAuthorizedReadFromApplication.add(authorizedRead);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedReadFromApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedReadFromApplication == null) {
        _cacheParentAuthorizedReadFromApplication = new HashSet<>();
        for (Application _0 : containingApp) {
          _cacheParentAuthorizedReadFromApplication.add(_0.specificAccessRead);
        }
        for (Application _1 : senderApp) {
          _cacheParentAuthorizedReadFromApplication.add(_1.specificAccessRead);
        }
        for (Application _2 : receiverApp) {
          _cacheParentAuthorizedReadFromApplication.add(_2.specificAccessRead);
        }
        _cacheParentAuthorizedReadFromApplication.add(authorizedAccessFromApplication);
      }
      for (AttackStep attackStep : _cacheParentAuthorizedReadFromApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedReadFromApplication");
    }
  }

  public class AuthorizedRead extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAuthorizedRead;

    private Set<AttackStep> _cacheParentAuthorizedRead;

    public AuthorizedRead(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedRead == null) {
        _cacheChildrenAuthorizedRead = new HashSet<>();
        _cacheChildrenAuthorizedRead.add(attemptRead);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedRead == null) {
        _cacheParentAuthorizedRead = new HashSet<>();
        _cacheParentAuthorizedRead.add(authorizedReadFromIAM);
        _cacheParentAuthorizedRead.add(authorizedReadFromApplication);
      }
      for (AttackStep attackStep : _cacheParentAuthorizedRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedRead");
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
          _cacheParentAttemptWrite.add(hardware.fullAccess);
        }
        if (hardware != null) {
          _cacheParentAttemptWrite.add(hardware.modify);
        }
        for (Application _0 : containingApp) {
          _cacheParentAttemptWrite.add(_0.modify);
        }
        for (Application _1 : senderApp) {
          _cacheParentAttemptWrite.add(_1.modify);
        }
        for (Data _2 : containingData) {
          _cacheParentAttemptWrite.add(_2.write);
        }
        _cacheParentAttemptWrite.add(authorizedWrite);
        for (Network _3 : transitNetwork) {
          _cacheParentAttemptWrite.add(_3.adversaryInTheMiddle);
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
        _cacheParentSuccessfulWrite.add(notPresent.disable);
        _cacheParentSuccessfulWrite.add(accessSpoofedData);
        _cacheParentSuccessfulWrite.add(accessDecryptedData);
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
        for (Information _1 : information) {
          _cacheChildrenWrite.add(_1.write);
        }
        for (Information _2 : replicatedInformation) {
          _cacheChildrenWrite.add(_2.attemptWriteFromReplica);
        }
        for (Application _3 : dependentApps) {
          _cacheChildrenWrite.add(_3.fullAccess);
        }
        _cacheChildrenWrite.add(attemptDelete);
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
        for (Information _4 : replicatedInformation) {
          _cacheParentWrite.add(_4.write);
        }
        for (Information _5 : information) {
          _cacheParentWrite.add(_5.write);
        }
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

  public class AuthorizedWriteFromIAM extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedWriteFromIAM;

    private Set<AttackStep> _cacheParentAuthorizedWriteFromIAM;

    public AuthorizedWriteFromIAM(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedWriteFromIAM == null) {
        _cacheChildrenAuthorizedWriteFromIAM = new HashSet<>();
        _cacheChildrenAuthorizedWriteFromIAM.add(authorizedWrite);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedWriteFromIAM) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedWriteFromIAM == null) {
        _cacheParentAuthorizedWriteFromIAM = new HashSet<>();
        for (IAMObject _0 : writingIAMs) {
          _cacheParentAuthorizedWriteFromIAM.add(_0.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentAuthorizedWriteFromIAM) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedWriteFromIAM");
    }
  }

  public class AuthorizedWriteFromApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedWriteFromApplication;

    private Set<AttackStep> _cacheParentAuthorizedWriteFromApplication;

    public AuthorizedWriteFromApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedWriteFromApplication == null) {
        _cacheChildrenAuthorizedWriteFromApplication = new HashSet<>();
        _cacheChildrenAuthorizedWriteFromApplication.add(authorizedWrite);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedWriteFromApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedWriteFromApplication == null) {
        _cacheParentAuthorizedWriteFromApplication = new HashSet<>();
        for (Application _0 : containingApp) {
          _cacheParentAuthorizedWriteFromApplication.add(_0.specificAccessModify);
        }
        for (Application _1 : senderApp) {
          _cacheParentAuthorizedWriteFromApplication.add(_1.specificAccessModify);
        }
        _cacheParentAuthorizedWriteFromApplication.add(authorizedAccessFromApplication);
      }
      for (AttackStep attackStep : _cacheParentAuthorizedWriteFromApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedWriteFromApplication");
    }
  }

  public class AuthorizedWrite extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAuthorizedWrite;

    private Set<AttackStep> _cacheParentAuthorizedWrite;

    public AuthorizedWrite(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedWrite == null) {
        _cacheChildrenAuthorizedWrite = new HashSet<>();
        _cacheChildrenAuthorizedWrite.add(attemptWrite);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedWrite) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedWrite == null) {
        _cacheParentAuthorizedWrite = new HashSet<>();
        _cacheParentAuthorizedWrite.add(authorizedWriteFromIAM);
        _cacheParentAuthorizedWrite.add(authorizedWriteFromApplication);
      }
      for (AttackStep attackStep : _cacheParentAuthorizedWrite) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedWrite");
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
        _cacheParentAttemptDelete.add(write);
        for (Data _0 : containingData) {
          _cacheParentAttemptDelete.add(_0.delete);
        }
        _cacheParentAttemptDelete.add(authorizedDelete);
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
        _cacheParentSuccessfulDelete.add(notPresent.disable);
        _cacheParentSuccessfulDelete.add(accessDecryptedData);
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
        for (Information _1 : information) {
          _cacheChildrenDelete.add(_1.delete);
        }
        for (Information _2 : replicatedInformation) {
          _cacheChildrenDelete.add(_2.attemptDeleteFromReplica);
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
        for (Information _3 : replicatedInformation) {
          _cacheParentDelete.add(_3.delete);
        }
        for (Information _4 : information) {
          _cacheParentDelete.add(_4.delete);
        }
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

  public class AuthorizedDeleteFromIAM extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedDeleteFromIAM;

    private Set<AttackStep> _cacheParentAuthorizedDeleteFromIAM;

    public AuthorizedDeleteFromIAM(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedDeleteFromIAM == null) {
        _cacheChildrenAuthorizedDeleteFromIAM = new HashSet<>();
        _cacheChildrenAuthorizedDeleteFromIAM.add(authorizedDelete);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedDeleteFromIAM) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedDeleteFromIAM == null) {
        _cacheParentAuthorizedDeleteFromIAM = new HashSet<>();
        for (IAMObject _0 : deletingIAMs) {
          _cacheParentAuthorizedDeleteFromIAM.add(_0.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentAuthorizedDeleteFromIAM) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedDeleteFromIAM");
    }
  }

  public class AuthorizedDeleteFromApplication extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedDeleteFromApplication;

    private Set<AttackStep> _cacheParentAuthorizedDeleteFromApplication;

    public AuthorizedDeleteFromApplication(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedDeleteFromApplication == null) {
        _cacheChildrenAuthorizedDeleteFromApplication = new HashSet<>();
        _cacheChildrenAuthorizedDeleteFromApplication.add(authorizedDelete);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedDeleteFromApplication) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedDeleteFromApplication == null) {
        _cacheParentAuthorizedDeleteFromApplication = new HashSet<>();
        for (Application _0 : containingApp) {
          _cacheParentAuthorizedDeleteFromApplication.add(_0.specificAccessDelete);
        }
        for (Application _1 : senderApp) {
          _cacheParentAuthorizedDeleteFromApplication.add(_1.specificAccessDelete);
        }
        _cacheParentAuthorizedDeleteFromApplication.add(authorizedAccessFromApplication);
      }
      for (AttackStep attackStep : _cacheParentAuthorizedDeleteFromApplication) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedDeleteFromApplication");
    }
  }

  public class AuthorizedDelete extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAuthorizedDelete;

    private Set<AttackStep> _cacheParentAuthorizedDelete;

    public AuthorizedDelete(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedDelete == null) {
        _cacheChildrenAuthorizedDelete = new HashSet<>();
        _cacheChildrenAuthorizedDelete.add(attemptDelete);
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedDelete) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedDelete == null) {
        _cacheParentAuthorizedDelete = new HashSet<>();
        _cacheParentAuthorizedDelete.add(authorizedDeleteFromIAM);
        _cacheParentAuthorizedDelete.add(authorizedDeleteFromApplication);
      }
      for (AttackStep attackStep : _cacheParentAuthorizedDelete) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.authorizedDelete");
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
        for (Application _1 : senderApp) {
          _cacheParentAttemptDeny.add(_1.deny);
        }
        _cacheParentAttemptDeny.add(delete);
        for (Data _2 : containingData) {
          _cacheParentAttemptDeny.add(_2.deny);
        }
        _cacheParentAttemptDeny.add(denyFromLockout);
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
        _cacheParentSuccessfulDeny.add(notPresent.disable);
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
        for (Information _1 : information) {
          _cacheChildrenDeny.add(_1.deny);
        }
        for (Information _2 : replicatedInformation) {
          _cacheChildrenDeny.add(_2.attemptDenyFromReplica);
        }
        for (Application _3 : dependentApps) {
          _cacheChildrenDeny.add(_3.deny);
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
        for (Information _4 : replicatedInformation) {
          _cacheParentDeny.add(_4.deny);
        }
        for (Information _5 : information) {
          _cacheParentDeny.add(_5.deny);
        }
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

  public class DenyFromLockout extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDenyFromLockout;

    private Set<AttackStep> _cacheParentDenyFromLockout;

    public DenyFromLockout(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyFromLockout == null) {
        _cacheChildrenDenyFromLockout = new HashSet<>();
        _cacheChildrenDenyFromLockout.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheChildrenDenyFromLockout) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyFromLockout == null) {
        _cacheParentDenyFromLockout = new HashSet<>();
        for (IAMObject _0 : readingIAMs) {
          _cacheParentDenyFromLockout.add(_0.lockout);
        }
      }
      for (AttackStep attackStep : _cacheParentDenyFromLockout) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Data.denyFromLockout");
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
        _cacheParentReverseReach.add(notPresent.disable);
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
          _cacheChildrenExtract.add(_0.extract);
        }
        for (Information _1 : replicatedInformation) {
          _cacheChildrenExtract.add(_1.attemptExtractFromReplica);
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
        _cacheParentExtract.add(notPresent.disable);
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
}
