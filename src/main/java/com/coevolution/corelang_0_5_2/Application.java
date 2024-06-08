package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Application extends Asset {
  public Disabled disabled;

  public AttemptUseVulnerability attemptUseVulnerability;

  public SuccessfulUseVulnerability successfulUseVulnerability;

  public UseVulnerability useVulnerability;

  public AttemptReverseReach attemptReverseReach;

  public SuccessfulReverseReach successfulReverseReach;

  public ReverseReach reverseReach;

  public LocalConnect localConnect;

  public NetworkConnect networkConnect;

  public NetworkConnectWithoutTriggeringVulnerabilities networkConnectWithoutTriggeringVulnerabilities;

  public AccessNetworkAndConnections accessNetworkAndConnections;

  public AttemptNetworkConnectViaResponse attemptNetworkConnectViaResponse;

  public NetworkConnectViaResponse networkConnectViaResponse;

  public SpecificAccessFromLocalConnection specificAccessFromLocalConnection;

  public SpecificAccessFromNetworkConnection specificAccessFromNetworkConnection;

  public SpecificAccess specificAccess;

  public AttemptLocalConnectVulnOnHost attemptLocalConnectVulnOnHost;

  public Authenticate authenticate;

  public SpecificAccessAuthenticate specificAccessAuthenticate;

  public LocalAccess localAccess;

  public NetworkAccess networkAccess;

  public FullAccess fullAccess;

  public PhysicalAccessAchieved physicalAccessAchieved;

  public AttemptUnsafeActivityByUser attemptUnsafeActivityByUser;

  public UnsafeActivityByUser unsafeActivityByUser;

  public UnsafeUserActivityWithAttackerInteraction unsafeUserActivityWithAttackerInteraction;

  public UnsafeUserActivityWithoutAttackerInteraction unsafeUserActivityWithoutAttackerInteraction;

  public AttemptUnsafeUserActivity attemptUnsafeUserActivity;

  public SupplyChainAuditing supplyChainAuditing;

  public AttemptFullAccessAfterSoftProdCompromise attemptFullAccessAfterSoftProdCompromise;

  public FullAccessAfterSoftProdCompromise fullAccessAfterSoftProdCompromise;

  public AttemptFullAccessAfterSoftProdVulnerability attemptFullAccessAfterSoftProdVulnerability;

  public AttemptReadAfterSoftProdVulnerability attemptReadAfterSoftProdVulnerability;

  public AttemptModifyAfterSoftProdVulnerability attemptModifyAfterSoftProdVulnerability;

  public AttemptDenyAfterSoftProdVulnerability attemptDenyAfterSoftProdVulnerability;

  public SoftwareCheck softwareCheck;

  public SoftwareProductVulnerabilityLocalAccessAchieved softwareProductVulnerabilityLocalAccessAchieved;

  public SoftwareProductVulnerabilityNetworkAccessAchieved softwareProductVulnerabilityNetworkAccessAchieved;

  public SoftwareProductVulnerabilityPhysicalAccessAchieved softwareProductVulnerabilityPhysicalAccessAchieved;

  public SoftwareProductVulnerabilityLowPrivilegesAchieved softwareProductVulnerabilityLowPrivilegesAchieved;

  public SoftwareProductVulnerabilityHighPrivilegesAchieved softwareProductVulnerabilityHighPrivilegesAchieved;

  public SoftwareProductVulnerabilityUserInteractionAchieved softwareProductVulnerabilityUserInteractionAchieved;

  public AttemptSoftwareProductAbuse attemptSoftwareProductAbuse;

  public SoftwareProductAbuse softwareProductAbuse;

  public FullAccessAfterSoftProdVulnerability fullAccessAfterSoftProdVulnerability;

  public ReadAfterSoftProdVulnerability readAfterSoftProdVulnerability;

  public ModifyAfterSoftProdVulnerability modifyAfterSoftProdVulnerability;

  public DenyAfterSoftProdVulnerability denyAfterSoftProdVulnerability;

  public AttemptApplicationRespondConnectThroughData attemptApplicationRespondConnectThroughData;

  public SuccessfulApplicationRespondConnectThroughData successfulApplicationRespondConnectThroughData;

  public ApplicationRespondConnectThroughData applicationRespondConnectThroughData;

  public AttemptRead attemptRead;

  public SuccessfulRead successfulRead;

  public Read read;

  public AttemptModify attemptModify;

  public SuccessfulModify successfulModify;

  public Modify modify;

  public AttemptDeny attemptDeny;

  public SuccessfulDeny successfulDeny;

  public Deny deny;

  public DenyFromNetworkingAsset denyFromNetworkingAsset;

  private Set<SoftwareVulnerability> _cacheallVulnerabilitiesApplication;

  private Set<ConnectionRule> _cacheserverApplicationConnectionsApplication;

  private Set<ConnectionRule> _cacheclientApplicationConnectionsApplication;

  private Set<Network> _cachereverseallNetApplicationsNetwork;

  private Set<Network> _cachereverseallowedApplicationConnectionsApplicationsNetwork;

  private Set<ConnectionRule> _cachereverseclientApplicationsConnectionRule;

  private Set<ConnectionRule> _cachereverseserverApplicationsConnectionRule;

  private Set<ConnectionRule> _cachereverseallApplicationsConnectionRule;

  public Set<SoftwareVulnerability> vulnerabilities = new HashSet<>();

  public Hardware hostHardware = null;

  public Set<Application> appExecutedApps = new HashSet<>();

  public Application hostApp = null;

  public Set<IDPS> protectorIDPSs = new HashSet<>();

  public SoftwareProduct appSoftProduct = null;

  public Set<RoutingFirewall> managedRoutingFw = new HashSet<>();

  public Set<Network> networks = new HashSet<>();

  public Set<Network> clientAccessNetworks = new HashSet<>();

  public Set<ConnectionRule> appConnections = new HashSet<>();

  public Set<ConnectionRule> ingoingAppConnections = new HashSet<>();

  public Set<ConnectionRule> outgoingAppConnections = new HashSet<>();

  public Set<Data> containedData = new HashSet<>();

  public Set<Data> sentData = new HashSet<>();

  public Set<Data> receivedData = new HashSet<>();

  public Set<IAMObject> executionPrivIAMs = new HashSet<>();

  public Set<IAMObject> highPrivAppIAMs = new HashSet<>();

  public Set<IAMObject> lowPrivAppIAMs = new HashSet<>();

  public Application(String name, boolean isDisabledEnabled, boolean isSupplyChainAuditingEnabled) {
    super(name);
    assetClassName = "Application";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, isDisabledEnabled);
    AttackStep.allAttackSteps.remove(attemptUseVulnerability);
    attemptUseVulnerability = new AttemptUseVulnerability(name);
    AttackStep.allAttackSteps.remove(successfulUseVulnerability);
    successfulUseVulnerability = new SuccessfulUseVulnerability(name);
    AttackStep.allAttackSteps.remove(useVulnerability);
    useVulnerability = new UseVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(successfulReverseReach);
    successfulReverseReach = new SuccessfulReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(localConnect);
    localConnect = new LocalConnect(name);
    AttackStep.allAttackSteps.remove(networkConnect);
    networkConnect = new NetworkConnect(name);
    AttackStep.allAttackSteps.remove(networkConnectWithoutTriggeringVulnerabilities);
    networkConnectWithoutTriggeringVulnerabilities = new NetworkConnectWithoutTriggeringVulnerabilities(name);
    AttackStep.allAttackSteps.remove(accessNetworkAndConnections);
    accessNetworkAndConnections = new AccessNetworkAndConnections(name);
    AttackStep.allAttackSteps.remove(attemptNetworkConnectViaResponse);
    attemptNetworkConnectViaResponse = new AttemptNetworkConnectViaResponse(name);
    AttackStep.allAttackSteps.remove(networkConnectViaResponse);
    networkConnectViaResponse = new NetworkConnectViaResponse(name);
    AttackStep.allAttackSteps.remove(specificAccessFromLocalConnection);
    specificAccessFromLocalConnection = new SpecificAccessFromLocalConnection(name);
    AttackStep.allAttackSteps.remove(specificAccessFromNetworkConnection);
    specificAccessFromNetworkConnection = new SpecificAccessFromNetworkConnection(name);
    AttackStep.allAttackSteps.remove(specificAccess);
    specificAccess = new SpecificAccess(name);
    AttackStep.allAttackSteps.remove(attemptLocalConnectVulnOnHost);
    attemptLocalConnectVulnOnHost = new AttemptLocalConnectVulnOnHost(name);
    AttackStep.allAttackSteps.remove(authenticate);
    authenticate = new Authenticate(name);
    AttackStep.allAttackSteps.remove(specificAccessAuthenticate);
    specificAccessAuthenticate = new SpecificAccessAuthenticate(name);
    AttackStep.allAttackSteps.remove(localAccess);
    localAccess = new LocalAccess(name);
    AttackStep.allAttackSteps.remove(networkAccess);
    networkAccess = new NetworkAccess(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(physicalAccessAchieved);
    physicalAccessAchieved = new PhysicalAccessAchieved(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeActivityByUser);
    attemptUnsafeActivityByUser = new AttemptUnsafeActivityByUser(name);
    AttackStep.allAttackSteps.remove(unsafeActivityByUser);
    unsafeActivityByUser = new UnsafeActivityByUser(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivityWithAttackerInteraction);
    unsafeUserActivityWithAttackerInteraction = new UnsafeUserActivityWithAttackerInteraction(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivityWithoutAttackerInteraction);
    unsafeUserActivityWithoutAttackerInteraction = new UnsafeUserActivityWithoutAttackerInteraction(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    if (supplyChainAuditing != null) {
      AttackStep.allAttackSteps.remove(supplyChainAuditing.disable);
    }
    Defense.allDefenses.remove(supplyChainAuditing);
    supplyChainAuditing = new SupplyChainAuditing(name, isSupplyChainAuditingEnabled);
    AttackStep.allAttackSteps.remove(attemptFullAccessAfterSoftProdCompromise);
    attemptFullAccessAfterSoftProdCompromise = new AttemptFullAccessAfterSoftProdCompromise(name);
    AttackStep.allAttackSteps.remove(fullAccessAfterSoftProdCompromise);
    fullAccessAfterSoftProdCompromise = new FullAccessAfterSoftProdCompromise(name);
    AttackStep.allAttackSteps.remove(attemptFullAccessAfterSoftProdVulnerability);
    attemptFullAccessAfterSoftProdVulnerability = new AttemptFullAccessAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptReadAfterSoftProdVulnerability);
    attemptReadAfterSoftProdVulnerability = new AttemptReadAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptModifyAfterSoftProdVulnerability);
    attemptModifyAfterSoftProdVulnerability = new AttemptModifyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptDenyAfterSoftProdVulnerability);
    attemptDenyAfterSoftProdVulnerability = new AttemptDenyAfterSoftProdVulnerability(name);
    if (softwareCheck != null) {
      AttackStep.allAttackSteps.remove(softwareCheck.disable);
    }
    Defense.allDefenses.remove(softwareCheck);
    softwareCheck = new SoftwareCheck(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityLocalAccessAchieved);
    softwareProductVulnerabilityLocalAccessAchieved = new SoftwareProductVulnerabilityLocalAccessAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityNetworkAccessAchieved);
    softwareProductVulnerabilityNetworkAccessAchieved = new SoftwareProductVulnerabilityNetworkAccessAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityPhysicalAccessAchieved);
    softwareProductVulnerabilityPhysicalAccessAchieved = new SoftwareProductVulnerabilityPhysicalAccessAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityLowPrivilegesAchieved);
    softwareProductVulnerabilityLowPrivilegesAchieved = new SoftwareProductVulnerabilityLowPrivilegesAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityHighPrivilegesAchieved);
    softwareProductVulnerabilityHighPrivilegesAchieved = new SoftwareProductVulnerabilityHighPrivilegesAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityUserInteractionAchieved);
    softwareProductVulnerabilityUserInteractionAchieved = new SoftwareProductVulnerabilityUserInteractionAchieved(name);
    AttackStep.allAttackSteps.remove(attemptSoftwareProductAbuse);
    attemptSoftwareProductAbuse = new AttemptSoftwareProductAbuse(name);
    AttackStep.allAttackSteps.remove(softwareProductAbuse);
    softwareProductAbuse = new SoftwareProductAbuse(name);
    AttackStep.allAttackSteps.remove(fullAccessAfterSoftProdVulnerability);
    fullAccessAfterSoftProdVulnerability = new FullAccessAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(readAfterSoftProdVulnerability);
    readAfterSoftProdVulnerability = new ReadAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(modifyAfterSoftProdVulnerability);
    modifyAfterSoftProdVulnerability = new ModifyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(denyAfterSoftProdVulnerability);
    denyAfterSoftProdVulnerability = new DenyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnectThroughData);
    attemptApplicationRespondConnectThroughData = new AttemptApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(successfulApplicationRespondConnectThroughData);
    successfulApplicationRespondConnectThroughData = new SuccessfulApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(applicationRespondConnectThroughData);
    applicationRespondConnectThroughData = new ApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(attemptRead);
    attemptRead = new AttemptRead(name);
    AttackStep.allAttackSteps.remove(successfulRead);
    successfulRead = new SuccessfulRead(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(attemptModify);
    attemptModify = new AttemptModify(name);
    AttackStep.allAttackSteps.remove(successfulModify);
    successfulModify = new SuccessfulModify(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(successfulDeny);
    successfulDeny = new SuccessfulDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(denyFromNetworkingAsset);
    denyFromNetworkingAsset = new DenyFromNetworkingAsset(name);
  }

  public Application(String name) {
    super(name);
    assetClassName = "Application";
    if (disabled != null) {
      AttackStep.allAttackSteps.remove(disabled.disable);
    }
    Defense.allDefenses.remove(disabled);
    disabled = new Disabled(name, false);
    AttackStep.allAttackSteps.remove(attemptUseVulnerability);
    attemptUseVulnerability = new AttemptUseVulnerability(name);
    AttackStep.allAttackSteps.remove(successfulUseVulnerability);
    successfulUseVulnerability = new SuccessfulUseVulnerability(name);
    AttackStep.allAttackSteps.remove(useVulnerability);
    useVulnerability = new UseVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(successfulReverseReach);
    successfulReverseReach = new SuccessfulReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(localConnect);
    localConnect = new LocalConnect(name);
    AttackStep.allAttackSteps.remove(networkConnect);
    networkConnect = new NetworkConnect(name);
    AttackStep.allAttackSteps.remove(networkConnectWithoutTriggeringVulnerabilities);
    networkConnectWithoutTriggeringVulnerabilities = new NetworkConnectWithoutTriggeringVulnerabilities(name);
    AttackStep.allAttackSteps.remove(accessNetworkAndConnections);
    accessNetworkAndConnections = new AccessNetworkAndConnections(name);
    AttackStep.allAttackSteps.remove(attemptNetworkConnectViaResponse);
    attemptNetworkConnectViaResponse = new AttemptNetworkConnectViaResponse(name);
    AttackStep.allAttackSteps.remove(networkConnectViaResponse);
    networkConnectViaResponse = new NetworkConnectViaResponse(name);
    AttackStep.allAttackSteps.remove(specificAccessFromLocalConnection);
    specificAccessFromLocalConnection = new SpecificAccessFromLocalConnection(name);
    AttackStep.allAttackSteps.remove(specificAccessFromNetworkConnection);
    specificAccessFromNetworkConnection = new SpecificAccessFromNetworkConnection(name);
    AttackStep.allAttackSteps.remove(specificAccess);
    specificAccess = new SpecificAccess(name);
    AttackStep.allAttackSteps.remove(attemptLocalConnectVulnOnHost);
    attemptLocalConnectVulnOnHost = new AttemptLocalConnectVulnOnHost(name);
    AttackStep.allAttackSteps.remove(authenticate);
    authenticate = new Authenticate(name);
    AttackStep.allAttackSteps.remove(specificAccessAuthenticate);
    specificAccessAuthenticate = new SpecificAccessAuthenticate(name);
    AttackStep.allAttackSteps.remove(localAccess);
    localAccess = new LocalAccess(name);
    AttackStep.allAttackSteps.remove(networkAccess);
    networkAccess = new NetworkAccess(name);
    AttackStep.allAttackSteps.remove(fullAccess);
    fullAccess = new FullAccess(name);
    AttackStep.allAttackSteps.remove(physicalAccessAchieved);
    physicalAccessAchieved = new PhysicalAccessAchieved(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeActivityByUser);
    attemptUnsafeActivityByUser = new AttemptUnsafeActivityByUser(name);
    AttackStep.allAttackSteps.remove(unsafeActivityByUser);
    unsafeActivityByUser = new UnsafeActivityByUser(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivityWithAttackerInteraction);
    unsafeUserActivityWithAttackerInteraction = new UnsafeUserActivityWithAttackerInteraction(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivityWithoutAttackerInteraction);
    unsafeUserActivityWithoutAttackerInteraction = new UnsafeUserActivityWithoutAttackerInteraction(name);
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    if (supplyChainAuditing != null) {
      AttackStep.allAttackSteps.remove(supplyChainAuditing.disable);
    }
    Defense.allDefenses.remove(supplyChainAuditing);
    supplyChainAuditing = new SupplyChainAuditing(name, false);
    AttackStep.allAttackSteps.remove(attemptFullAccessAfterSoftProdCompromise);
    attemptFullAccessAfterSoftProdCompromise = new AttemptFullAccessAfterSoftProdCompromise(name);
    AttackStep.allAttackSteps.remove(fullAccessAfterSoftProdCompromise);
    fullAccessAfterSoftProdCompromise = new FullAccessAfterSoftProdCompromise(name);
    AttackStep.allAttackSteps.remove(attemptFullAccessAfterSoftProdVulnerability);
    attemptFullAccessAfterSoftProdVulnerability = new AttemptFullAccessAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptReadAfterSoftProdVulnerability);
    attemptReadAfterSoftProdVulnerability = new AttemptReadAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptModifyAfterSoftProdVulnerability);
    attemptModifyAfterSoftProdVulnerability = new AttemptModifyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptDenyAfterSoftProdVulnerability);
    attemptDenyAfterSoftProdVulnerability = new AttemptDenyAfterSoftProdVulnerability(name);
    if (softwareCheck != null) {
      AttackStep.allAttackSteps.remove(softwareCheck.disable);
    }
    Defense.allDefenses.remove(softwareCheck);
    softwareCheck = new SoftwareCheck(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityLocalAccessAchieved);
    softwareProductVulnerabilityLocalAccessAchieved = new SoftwareProductVulnerabilityLocalAccessAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityNetworkAccessAchieved);
    softwareProductVulnerabilityNetworkAccessAchieved = new SoftwareProductVulnerabilityNetworkAccessAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityPhysicalAccessAchieved);
    softwareProductVulnerabilityPhysicalAccessAchieved = new SoftwareProductVulnerabilityPhysicalAccessAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityLowPrivilegesAchieved);
    softwareProductVulnerabilityLowPrivilegesAchieved = new SoftwareProductVulnerabilityLowPrivilegesAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityHighPrivilegesAchieved);
    softwareProductVulnerabilityHighPrivilegesAchieved = new SoftwareProductVulnerabilityHighPrivilegesAchieved(name);
    AttackStep.allAttackSteps.remove(softwareProductVulnerabilityUserInteractionAchieved);
    softwareProductVulnerabilityUserInteractionAchieved = new SoftwareProductVulnerabilityUserInteractionAchieved(name);
    AttackStep.allAttackSteps.remove(attemptSoftwareProductAbuse);
    attemptSoftwareProductAbuse = new AttemptSoftwareProductAbuse(name);
    AttackStep.allAttackSteps.remove(softwareProductAbuse);
    softwareProductAbuse = new SoftwareProductAbuse(name);
    AttackStep.allAttackSteps.remove(fullAccessAfterSoftProdVulnerability);
    fullAccessAfterSoftProdVulnerability = new FullAccessAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(readAfterSoftProdVulnerability);
    readAfterSoftProdVulnerability = new ReadAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(modifyAfterSoftProdVulnerability);
    modifyAfterSoftProdVulnerability = new ModifyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(denyAfterSoftProdVulnerability);
    denyAfterSoftProdVulnerability = new DenyAfterSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnectThroughData);
    attemptApplicationRespondConnectThroughData = new AttemptApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(successfulApplicationRespondConnectThroughData);
    successfulApplicationRespondConnectThroughData = new SuccessfulApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(applicationRespondConnectThroughData);
    applicationRespondConnectThroughData = new ApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(attemptRead);
    attemptRead = new AttemptRead(name);
    AttackStep.allAttackSteps.remove(successfulRead);
    successfulRead = new SuccessfulRead(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(attemptModify);
    attemptModify = new AttemptModify(name);
    AttackStep.allAttackSteps.remove(successfulModify);
    successfulModify = new SuccessfulModify(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(successfulDeny);
    successfulDeny = new SuccessfulDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(denyFromNetworkingAsset);
    denyFromNetworkingAsset = new DenyFromNetworkingAsset(name);
  }

  public Application(boolean isDisabledEnabled, boolean isSupplyChainAuditingEnabled) {
    this("Anonymous", isDisabledEnabled, isSupplyChainAuditingEnabled);
  }

  public Application() {
    this("Anonymous");
  }

  protected Set<SoftwareVulnerability> _allVulnerabilitiesApplication() {
    if (_cacheallVulnerabilitiesApplication == null) {
      _cacheallVulnerabilitiesApplication = new HashSet<>();
      Set<SoftwareVulnerability> _2 = new HashSet<>();
      Set<SoftwareVulnerability> _3 = new HashSet<>();
      for (SoftwareVulnerability _4 : vulnerabilities) {
        _2.add(_4);
      }
      if (appSoftProduct != null) {
        for (SoftwareVulnerability _5 : appSoftProduct.softProductVulnerabilities) {
          _3.add(_5);
        }
      }
      _2.addAll(_3);
      for (SoftwareVulnerability _6 : _2) {
        _cacheallVulnerabilitiesApplication.add(_6);
      }
    }
    return _cacheallVulnerabilitiesApplication;
  }

  protected Set<ConnectionRule> _serverApplicationConnectionsApplication() {
    if (_cacheserverApplicationConnectionsApplication == null) {
      _cacheserverApplicationConnectionsApplication = new HashSet<>();
      Set<ConnectionRule> _7 = new HashSet<>();
      Set<ConnectionRule> _8 = new HashSet<>();
      for (ConnectionRule _9 : appConnections) {
        _7.add(_9);
      }
      for (ConnectionRule _a : ingoingAppConnections) {
        _8.add(_a);
      }
      _7.addAll(_8);
      for (ConnectionRule _b : _7) {
        _cacheserverApplicationConnectionsApplication.add(_b);
      }
    }
    return _cacheserverApplicationConnectionsApplication;
  }

  protected Set<ConnectionRule> _clientApplicationConnectionsApplication() {
    if (_cacheclientApplicationConnectionsApplication == null) {
      _cacheclientApplicationConnectionsApplication = new HashSet<>();
      Set<ConnectionRule> _c = new HashSet<>();
      Set<ConnectionRule> _d = new HashSet<>();
      for (ConnectionRule _e : appConnections) {
        _c.add(_e);
      }
      for (ConnectionRule _f : outgoingAppConnections) {
        _d.add(_f);
      }
      _c.addAll(_d);
      for (ConnectionRule _10 : _c) {
        _cacheclientApplicationConnectionsApplication.add(_10);
      }
    }
    return _cacheclientApplicationConnectionsApplication;
  }

  protected Set<Network> _reverseallNetApplicationsNetwork() {
    if (_cachereverseallNetApplicationsNetwork == null) {
      _cachereverseallNetApplicationsNetwork = new HashSet<>();
      Set<Network> _11 = new HashSet<>();
      Set<Network> _12 = new HashSet<>();
      for (Network _13 : networks) {
        _11.add(_13);
      }
      for (Network _14 : clientAccessNetworks) {
        _12.add(_14);
      }
      _11.addAll(_12);
      for (Network _15 : _11) {
        _cachereverseallNetApplicationsNetwork.add(_15);
      }
    }
    return _cachereverseallNetApplicationsNetwork;
  }

  protected Set<Network> _reverseallowedApplicationConnectionsApplicationsNetwork() {
    if (_cachereverseallowedApplicationConnectionsApplicationsNetwork == null) {
      _cachereverseallowedApplicationConnectionsApplicationsNetwork = new HashSet<>();
      Set<Network> _16 = new HashSet<>();
      Set<Network> _17 = new HashSet<>();
      for (ConnectionRule _18 : appConnections) {
        for (var _19 : _18._reverseallNetConnectionsNetwork()) {
          _16.add(_19);
        }
      }
      for (var _1a : _reverseallNetApplicationsNetwork()) {
        _17.add(_1a);
      }
      _16.addAll(_17);
      for (Network _1b : _16) {
        _cachereverseallowedApplicationConnectionsApplicationsNetwork.add(_1b);
      }
    }
    return _cachereverseallowedApplicationConnectionsApplicationsNetwork;
  }

  protected Set<ConnectionRule> _reverseclientApplicationsConnectionRule() {
    if (_cachereverseclientApplicationsConnectionRule == null) {
      _cachereverseclientApplicationsConnectionRule = new HashSet<>();
      Set<ConnectionRule> _1c = new HashSet<>();
      Set<ConnectionRule> _1d = new HashSet<>();
      for (ConnectionRule _1e : outgoingAppConnections) {
        _1c.add(_1e);
      }
      for (ConnectionRule _1f : appConnections) {
        _1d.add(_1f);
      }
      _1c.addAll(_1d);
      for (ConnectionRule _20 : _1c) {
        _cachereverseclientApplicationsConnectionRule.add(_20);
      }
    }
    return _cachereverseclientApplicationsConnectionRule;
  }

  protected Set<ConnectionRule> _reverseserverApplicationsConnectionRule() {
    if (_cachereverseserverApplicationsConnectionRule == null) {
      _cachereverseserverApplicationsConnectionRule = new HashSet<>();
      Set<ConnectionRule> _21 = new HashSet<>();
      Set<ConnectionRule> _22 = new HashSet<>();
      for (ConnectionRule _23 : ingoingAppConnections) {
        _21.add(_23);
      }
      for (ConnectionRule _24 : appConnections) {
        _22.add(_24);
      }
      _21.addAll(_22);
      for (ConnectionRule _25 : _21) {
        _cachereverseserverApplicationsConnectionRule.add(_25);
      }
    }
    return _cachereverseserverApplicationsConnectionRule;
  }

  protected Set<ConnectionRule> _reverseallApplicationsConnectionRule() {
    if (_cachereverseallApplicationsConnectionRule == null) {
      _cachereverseallApplicationsConnectionRule = new HashSet<>();
      Set<ConnectionRule> _26 = new HashSet<>();
      Set<ConnectionRule> _27 = new HashSet<>();
      for (ConnectionRule _28 : outgoingAppConnections) {
        _26.add(_28);
      }
      Set<ConnectionRule> _29 = new HashSet<>();
      Set<ConnectionRule> _2a = new HashSet<>();
      for (ConnectionRule _2b : ingoingAppConnections) {
        _29.add(_2b);
      }
      for (ConnectionRule _2c : appConnections) {
        _2a.add(_2c);
      }
      _29.addAll(_2a);
      for (ConnectionRule _2d : _29) {
        _27.add(_2d);
      }
      _26.addAll(_27);
      for (ConnectionRule _2e : _26) {
        _cachereverseallApplicationsConnectionRule.add(_2e);
      }
    }
    return _cachereverseallApplicationsConnectionRule;
  }

  public void addVulnerabilities(SoftwareVulnerability vulnerabilities) {
    this.vulnerabilities.add(vulnerabilities);
    vulnerabilities.application = this;
  }

  public void addHostHardware(Hardware hostHardware) {
    this.hostHardware = hostHardware;
    hostHardware.sysExecutedApps.add(this);
  }

  public void addAppExecutedApps(Application appExecutedApps) {
    this.appExecutedApps.add(appExecutedApps);
    appExecutedApps.hostApp = this;
  }

  public void addHostApp(Application hostApp) {
    this.hostApp = hostApp;
    hostApp.appExecutedApps.add(this);
  }

  public void addProtectorIDPSs(IDPS protectorIDPSs) {
    this.protectorIDPSs.add(protectorIDPSs);
    protectorIDPSs.protectedApps.add(this);
  }

  public void addAppSoftProduct(SoftwareProduct appSoftProduct) {
    this.appSoftProduct = appSoftProduct;
    appSoftProduct.softApplications.add(this);
  }

  public void addManagedRoutingFw(RoutingFirewall managedRoutingFw) {
    this.managedRoutingFw.add(managedRoutingFw);
    managedRoutingFw.managerApp = this;
  }

  public void addNetworks(Network networks) {
    this.networks.add(networks);
    networks.applications.add(this);
  }

  public void addClientAccessNetworks(Network clientAccessNetworks) {
    this.clientAccessNetworks.add(clientAccessNetworks);
    clientAccessNetworks.clientApplications.add(this);
  }

  public void addAppConnections(ConnectionRule appConnections) {
    this.appConnections.add(appConnections);
    appConnections.applications.add(this);
  }

  public void addIngoingAppConnections(ConnectionRule ingoingAppConnections) {
    this.ingoingAppConnections.add(ingoingAppConnections);
    ingoingAppConnections.inApplications.add(this);
  }

  public void addOutgoingAppConnections(ConnectionRule outgoingAppConnections) {
    this.outgoingAppConnections.add(outgoingAppConnections);
    outgoingAppConnections.outApplications.add(this);
  }

  public void addContainedData(Data containedData) {
    this.containedData.add(containedData);
    containedData.containingApp.add(this);
  }

  public void addSentData(Data sentData) {
    this.sentData.add(sentData);
    sentData.senderApp.add(this);
  }

  public void addReceivedData(Data receivedData) {
    this.receivedData.add(receivedData);
    receivedData.receiverApp.add(this);
  }

  public void addExecutionPrivIAMs(IAMObject executionPrivIAMs) {
    this.executionPrivIAMs.add(executionPrivIAMs);
    executionPrivIAMs.execPrivApps.add(this);
  }

  public void addHighPrivAppIAMs(IAMObject highPrivAppIAMs) {
    this.highPrivAppIAMs.add(highPrivAppIAMs);
    highPrivAppIAMs.highPrivApps.add(this);
  }

  public void addLowPrivAppIAMs(IAMObject lowPrivAppIAMs) {
    this.lowPrivAppIAMs.add(lowPrivAppIAMs);
    lowPrivAppIAMs.lowPrivApps.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("vulnerabilities")) {
      return SoftwareVulnerability.class.getName();
    } else if (field.equals("hostHardware")) {
      return Hardware.class.getName();
    } else if (field.equals("appExecutedApps")) {
      return Application.class.getName();
    } else if (field.equals("hostApp")) {
      return Application.class.getName();
    } else if (field.equals("protectorIDPSs")) {
      return IDPS.class.getName();
    } else if (field.equals("appSoftProduct")) {
      return SoftwareProduct.class.getName();
    } else if (field.equals("managedRoutingFw")) {
      return RoutingFirewall.class.getName();
    } else if (field.equals("networks")) {
      return Network.class.getName();
    } else if (field.equals("clientAccessNetworks")) {
      return Network.class.getName();
    } else if (field.equals("appConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("ingoingAppConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("outgoingAppConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("containedData")) {
      return Data.class.getName();
    } else if (field.equals("sentData")) {
      return Data.class.getName();
    } else if (field.equals("receivedData")) {
      return Data.class.getName();
    } else if (field.equals("executionPrivIAMs")) {
      return IAMObject.class.getName();
    } else if (field.equals("highPrivAppIAMs")) {
      return IAMObject.class.getName();
    } else if (field.equals("lowPrivAppIAMs")) {
      return IAMObject.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("vulnerabilities")) {
      assets.addAll(vulnerabilities);
    } else if (field.equals("hostHardware")) {
      if (hostHardware != null) {
        assets.add(hostHardware);
      }
    } else if (field.equals("appExecutedApps")) {
      assets.addAll(appExecutedApps);
    } else if (field.equals("hostApp")) {
      if (hostApp != null) {
        assets.add(hostApp);
      }
    } else if (field.equals("protectorIDPSs")) {
      assets.addAll(protectorIDPSs);
    } else if (field.equals("appSoftProduct")) {
      if (appSoftProduct != null) {
        assets.add(appSoftProduct);
      }
    } else if (field.equals("managedRoutingFw")) {
      assets.addAll(managedRoutingFw);
    } else if (field.equals("networks")) {
      assets.addAll(networks);
    } else if (field.equals("clientAccessNetworks")) {
      assets.addAll(clientAccessNetworks);
    } else if (field.equals("appConnections")) {
      assets.addAll(appConnections);
    } else if (field.equals("ingoingAppConnections")) {
      assets.addAll(ingoingAppConnections);
    } else if (field.equals("outgoingAppConnections")) {
      assets.addAll(outgoingAppConnections);
    } else if (field.equals("containedData")) {
      assets.addAll(containedData);
    } else if (field.equals("sentData")) {
      assets.addAll(sentData);
    } else if (field.equals("receivedData")) {
      assets.addAll(receivedData);
    } else if (field.equals("executionPrivIAMs")) {
      assets.addAll(executionPrivIAMs);
    } else if (field.equals("highPrivAppIAMs")) {
      assets.addAll(highPrivAppIAMs);
    } else if (field.equals("lowPrivAppIAMs")) {
      assets.addAll(lowPrivAppIAMs);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(vulnerabilities);
    if (hostHardware != null) {
      assets.add(hostHardware);
    }
    assets.addAll(appExecutedApps);
    if (hostApp != null) {
      assets.add(hostApp);
    }
    assets.addAll(protectorIDPSs);
    if (appSoftProduct != null) {
      assets.add(appSoftProduct);
    }
    assets.addAll(managedRoutingFw);
    assets.addAll(networks);
    assets.addAll(clientAccessNetworks);
    assets.addAll(appConnections);
    assets.addAll(ingoingAppConnections);
    assets.addAll(outgoingAppConnections);
    assets.addAll(containedData);
    assets.addAll(sentData);
    assets.addAll(receivedData);
    assets.addAll(executionPrivIAMs);
    assets.addAll(highPrivAppIAMs);
    assets.addAll(lowPrivAppIAMs);
    return assets;
  }

  public class Disabled extends Defense {
    public Disabled(String name) {
      this(name, false);
    }

    public Disabled(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenDisabled;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenDisabled == null) {
          _cacheChildrenDisabled = new HashSet<>();
          _cacheChildrenDisabled.add(specificAccessFromLocalConnection);
          _cacheChildrenDisabled.add(specificAccessFromNetworkConnection);
          _cacheChildrenDisabled.add(localAccess);
          _cacheChildrenDisabled.add(networkAccess);
          _cacheChildrenDisabled.add(fullAccessAfterSoftProdVulnerability);
          _cacheChildrenDisabled.add(readAfterSoftProdVulnerability);
          _cacheChildrenDisabled.add(modifyAfterSoftProdVulnerability);
          _cacheChildrenDisabled.add(denyAfterSoftProdVulnerability);
          _cacheChildrenDisabled.add(successfulReverseReach);
          _cacheChildrenDisabled.add(successfulUseVulnerability);
          _cacheChildrenDisabled.add(successfulApplicationRespondConnectThroughData);
          _cacheChildrenDisabled.add(successfulRead);
          _cacheChildrenDisabled.add(successfulModify);
          _cacheChildrenDisabled.add(successfulDeny);
        }
        for (AttackStep attackStep : _cacheChildrenDisabled) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Application.disabled";
      }
    }
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
        _cacheChildrenAttemptUseVulnerability.add(successfulUseVulnerability);
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
        _cacheParentAttemptUseVulnerability.add(localConnect);
        _cacheParentAttemptUseVulnerability.add(networkConnect);
        _cacheParentAttemptUseVulnerability.add(specificAccess);
        for (Application _0 : appExecutedApps) {
          _cacheParentAttemptUseVulnerability.add(_0.attemptLocalConnectVulnOnHost);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptUseVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptUseVulnerability");
    }
  }

  public class SuccessfulUseVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulUseVulnerability;

    private Set<AttackStep> _cacheParentSuccessfulUseVulnerability;

    public SuccessfulUseVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulUseVulnerability == null) {
        _cacheChildrenSuccessfulUseVulnerability = new HashSet<>();
        _cacheChildrenSuccessfulUseVulnerability.add(useVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulUseVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulUseVulnerability == null) {
        _cacheParentSuccessfulUseVulnerability = new HashSet<>();
        _cacheParentSuccessfulUseVulnerability.add(disabled.disable);
        _cacheParentSuccessfulUseVulnerability.add(attemptUseVulnerability);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulUseVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.successfulUseVulnerability");
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
        for (var _0 : _allVulnerabilitiesApplication()) {
          _cacheChildrenUseVulnerability.add(_0.attemptAbuse);
        }
        _cacheChildrenUseVulnerability.add(attemptSoftwareProductAbuse);
        _cacheChildrenUseVulnerability.add(fullAccessAfterSoftProdVulnerability);
        _cacheChildrenUseVulnerability.add(readAfterSoftProdVulnerability);
        _cacheChildrenUseVulnerability.add(modifyAfterSoftProdVulnerability);
        _cacheChildrenUseVulnerability.add(denyAfterSoftProdVulnerability);
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
        _cacheParentUseVulnerability.add(successfulUseVulnerability);
        for (IDPS _1 : protectorIDPSs) {
          _cacheParentUseVulnerability.add(_1.protectionBypassed);
        }
      }
      for (AttackStep attackStep : _cacheParentUseVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.useVulnerability");
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
        _cacheChildrenAttemptReverseReach.add(successfulReverseReach);
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
        if (hostApp != null) {
          _cacheParentAttemptReverseReach.add(hostApp.reverseReach);
        }
        for (Network _0 : clientAccessNetworks) {
          _cacheParentAttemptReverseReach.add(_0.reverseReach);
        }
        for (Network _1 : networks) {
          _cacheParentAttemptReverseReach.add(_1.reverseReach);
        }
        for (var _2 : _reverseclientApplicationsConnectionRule()) {
          _cacheParentAttemptReverseReach.add(_2.reverseReach);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptReverseReach");
    }
  }

  public class SuccessfulReverseReach extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulReverseReach;

    private Set<AttackStep> _cacheParentSuccessfulReverseReach;

    public SuccessfulReverseReach(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulReverseReach == null) {
        _cacheChildrenSuccessfulReverseReach = new HashSet<>();
        _cacheChildrenSuccessfulReverseReach.add(reverseReach);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulReverseReach) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulReverseReach == null) {
        _cacheParentSuccessfulReverseReach = new HashSet<>();
        _cacheParentSuccessfulReverseReach.add(disabled.disable);
        _cacheParentSuccessfulReverseReach.add(attemptReverseReach);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.successfulReverseReach");
    }
  }

  public class ReverseReach extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenReverseReach;

    private Set<AttackStep> _cacheParentReverseReach;

    public ReverseReach(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReverseReach == null) {
        _cacheChildrenReverseReach = new HashSet<>();
        for (Network _0 : networks) {
          _cacheChildrenReverseReach.add(_0.attemptReverseReach);
        }
        for (Network _1 : clientAccessNetworks) {
          _cacheChildrenReverseReach.add(_1.attemptReverseReach);
        }
        for (var _2 : _serverApplicationConnectionsApplication()) {
          _cacheChildrenReverseReach.add(_2.attemptReverseReach);
        }
        for (Application _3 : appExecutedApps) {
          _cacheChildrenReverseReach.add(_3.attemptReverseReach);
        }
        _cacheChildrenReverseReach.add(unsafeUserActivityWithAttackerInteraction);
        for (Data _4 : containedData) {
          _cacheChildrenReverseReach.add(_4.attemptReverseReach);
        }
        for (Data _5 : sentData) {
          _cacheChildrenReverseReach.add(_5.attemptReverseReach);
        }
        for (Data _6 : receivedData) {
          _cacheChildrenReverseReach.add(_6.attemptReverseReach);
        }
        _cacheChildrenReverseReach.add(networkConnectViaResponse);
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
        _cacheParentReverseReach.add(successfulReverseReach);
      }
      for (AttackStep attackStep : _cacheParentReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.reverseReach");
    }
  }

  public class LocalConnect extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenLocalConnect;

    private Set<AttackStep> _cacheParentLocalConnect;

    public LocalConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenLocalConnect == null) {
        _cacheChildrenLocalConnect = new HashSet<>();
        _cacheChildrenLocalConnect.add(localAccess);
        _cacheChildrenLocalConnect.add(specificAccessFromLocalConnection);
        _cacheChildrenLocalConnect.add(attemptUseVulnerability);
        for (var _0 : _allVulnerabilitiesApplication()) {
          _cacheChildrenLocalConnect.add(_0.localAccessAchieved);
        }
        _cacheChildrenLocalConnect.add(softwareProductVulnerabilityLocalAccessAchieved);
      }
      for (AttackStep attackStep : _cacheChildrenLocalConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentLocalConnect == null) {
        _cacheParentLocalConnect = new HashSet<>();
        if (hostHardware != null) {
          _cacheParentLocalConnect.add(hostHardware.physicalAccess);
        }
        if (hostApp != null) {
          _cacheParentLocalConnect.add(hostApp.specificAccess);
        }
        for (Application _1 : appExecutedApps) {
          _cacheParentLocalConnect.add(_1.fullAccess);
        }
        _cacheParentLocalConnect.add(unsafeActivityByUser);
      }
      for (AttackStep attackStep : _cacheParentLocalConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.localConnect");
    }
  }

  public class NetworkConnect extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkConnect;

    private Set<AttackStep> _cacheParentNetworkConnect;

    public NetworkConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkConnect == null) {
        _cacheChildrenNetworkConnect = new HashSet<>();
        _cacheChildrenNetworkConnect.add(networkConnectWithoutTriggeringVulnerabilities);
        _cacheChildrenNetworkConnect.add(attemptUseVulnerability);
        for (var _0 : _allVulnerabilitiesApplication()) {
          _cacheChildrenNetworkConnect.add(_0.networkAccessAchieved);
        }
        _cacheChildrenNetworkConnect.add(softwareProductVulnerabilityNetworkAccessAchieved);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkConnect == null) {
        _cacheParentNetworkConnect = new HashSet<>();
        _cacheParentNetworkConnect.add(networkConnectViaResponse);
        _cacheParentNetworkConnect.add(unsafeActivityByUser);
        for (Network _1 : networks) {
          _cacheParentNetworkConnect.add(_1.successfulAccess);
        }
        for (ConnectionRule _2 : appConnections) {
          if (_2.routingFirewalls != null) {
            _cacheParentNetworkConnect.add(_2.routingFirewalls.fullAccess);
          }
        }
        for (var _3 : _reverseserverApplicationsConnectionRule()) {
          _cacheParentNetworkConnect.add(_3.connectToApplications);
        }
      }
      for (AttackStep attackStep : _cacheParentNetworkConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkConnect");
    }
  }

  public class NetworkConnectWithoutTriggeringVulnerabilities extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkConnectWithoutTriggeringVulnerabilities;

    private Set<AttackStep> _cacheParentNetworkConnectWithoutTriggeringVulnerabilities;

    public NetworkConnectWithoutTriggeringVulnerabilities(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkConnectWithoutTriggeringVulnerabilities == null) {
        _cacheChildrenNetworkConnectWithoutTriggeringVulnerabilities = new HashSet<>();
        _cacheChildrenNetworkConnectWithoutTriggeringVulnerabilities.add(networkAccess);
        _cacheChildrenNetworkConnectWithoutTriggeringVulnerabilities.add(specificAccessFromNetworkConnection);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkConnectWithoutTriggeringVulnerabilities) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkConnectWithoutTriggeringVulnerabilities == null) {
        _cacheParentNetworkConnectWithoutTriggeringVulnerabilities = new HashSet<>();
        _cacheParentNetworkConnectWithoutTriggeringVulnerabilities.add(networkConnect);
        for (var _0 : _reverseserverApplicationsConnectionRule()) {
          _cacheParentNetworkConnectWithoutTriggeringVulnerabilities.add(_0.connectToApplicationsWithoutTriggeringVulnerabilities);
        }
      }
      for (AttackStep attackStep : _cacheParentNetworkConnectWithoutTriggeringVulnerabilities) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkConnectWithoutTriggeringVulnerabilities");
    }
  }

  public class AccessNetworkAndConnections extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessNetworkAndConnections;

    private Set<AttackStep> _cacheParentAccessNetworkAndConnections;

    public AccessNetworkAndConnections(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessNetworkAndConnections == null) {
        _cacheChildrenAccessNetworkAndConnections = new HashSet<>();
        for (Network _0 : networks) {
          _cacheChildrenAccessNetworkAndConnections.add(_0.access);
        }
        for (Network _1 : clientAccessNetworks) {
          _cacheChildrenAccessNetworkAndConnections.add(_1.access);
        }
        for (var _2 : _clientApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_2.attemptConnectToApplications);
        }
        for (var _3 : _clientApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_3.attemptAccessNetworks);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAccessNetworkAndConnections) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessNetworkAndConnections == null) {
        _cacheParentAccessNetworkAndConnections = new HashSet<>();
        _cacheParentAccessNetworkAndConnections.add(specificAccess);
        _cacheParentAccessNetworkAndConnections.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheParentAccessNetworkAndConnections) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.accessNetworkAndConnections");
    }
  }

  public class AttemptNetworkConnectViaResponse extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptNetworkConnectViaResponse;

    private Set<AttackStep> _cacheParentAttemptNetworkConnectViaResponse;

    public AttemptNetworkConnectViaResponse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptNetworkConnectViaResponse == null) {
        _cacheChildrenAttemptNetworkConnectViaResponse = new HashSet<>();
        _cacheChildrenAttemptNetworkConnectViaResponse.add(networkConnectViaResponse);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptNetworkConnectViaResponse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptNetworkConnectViaResponse == null) {
        _cacheParentAttemptNetworkConnectViaResponse = new HashSet<>();
        for (Data _0 : sentData) {
          _cacheParentAttemptNetworkConnectViaResponse.add(_0.applicationRespondConnect);
        }
        for (Network _1 : clientAccessNetworks) {
          _cacheParentAttemptNetworkConnectViaResponse.add(_1.successfulAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptNetworkConnectViaResponse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptNetworkConnectViaResponse");
    }
  }

  public class NetworkConnectViaResponse extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenNetworkConnectViaResponse;

    private Set<AttackStep> _cacheParentNetworkConnectViaResponse;

    public NetworkConnectViaResponse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkConnectViaResponse == null) {
        _cacheChildrenNetworkConnectViaResponse = new HashSet<>();
        _cacheChildrenNetworkConnectViaResponse.add(networkConnect);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkConnectViaResponse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkConnectViaResponse == null) {
        _cacheParentNetworkConnectViaResponse = new HashSet<>();
        _cacheParentNetworkConnectViaResponse.add(reverseReach);
        _cacheParentNetworkConnectViaResponse.add(attemptNetworkConnectViaResponse);
      }
      for (AttackStep attackStep : _cacheParentNetworkConnectViaResponse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkConnectViaResponse");
    }
  }

  public class SpecificAccessFromLocalConnection extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSpecificAccessFromLocalConnection;

    private Set<AttackStep> _cacheParentSpecificAccessFromLocalConnection;

    public SpecificAccessFromLocalConnection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessFromLocalConnection == null) {
        _cacheChildrenSpecificAccessFromLocalConnection = new HashSet<>();
        _cacheChildrenSpecificAccessFromLocalConnection.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessFromLocalConnection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessFromLocalConnection == null) {
        _cacheParentSpecificAccessFromLocalConnection = new HashSet<>();
        _cacheParentSpecificAccessFromLocalConnection.add(disabled.disable);
        _cacheParentSpecificAccessFromLocalConnection.add(localConnect);
        _cacheParentSpecificAccessFromLocalConnection.add(specificAccessAuthenticate);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessFromLocalConnection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessFromLocalConnection");
    }
  }

  public class SpecificAccessFromNetworkConnection extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSpecificAccessFromNetworkConnection;

    private Set<AttackStep> _cacheParentSpecificAccessFromNetworkConnection;

    public SpecificAccessFromNetworkConnection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessFromNetworkConnection == null) {
        _cacheChildrenSpecificAccessFromNetworkConnection = new HashSet<>();
        _cacheChildrenSpecificAccessFromNetworkConnection.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessFromNetworkConnection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessFromNetworkConnection == null) {
        _cacheParentSpecificAccessFromNetworkConnection = new HashSet<>();
        _cacheParentSpecificAccessFromNetworkConnection.add(disabled.disable);
        _cacheParentSpecificAccessFromNetworkConnection.add(networkConnectWithoutTriggeringVulnerabilities);
        _cacheParentSpecificAccessFromNetworkConnection.add(specificAccessAuthenticate);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessFromNetworkConnection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessFromNetworkConnection");
    }
  }

  public class SpecificAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSpecificAccess;

    private Set<AttackStep> _cacheParentSpecificAccess;

    public SpecificAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccess == null) {
        _cacheChildrenSpecificAccess = new HashSet<>();
        for (Application _0 : appExecutedApps) {
          _cacheChildrenSpecificAccess.add(_0.localConnect);
        }
        _cacheChildrenSpecificAccess.add(attemptLocalConnectVulnOnHost);
        _cacheChildrenSpecificAccess.add(attemptUseVulnerability);
        for (Data _1 : containedData) {
          _cacheChildrenSpecificAccess.add(_1.attemptAccessFromIdentity);
        }
        for (Data _2 : sentData) {
          _cacheChildrenSpecificAccess.add(_2.identityAttemptRead);
        }
        for (Data _3 : receivedData) {
          _cacheChildrenSpecificAccess.add(_3.identityAttemptRead);
        }
        for (Data _4 : sentData) {
          _cacheChildrenSpecificAccess.add(_4.attemptIdentityWriteDataInTransitFromApplication);
        }
        for (var _5 : _clientApplicationConnectionsApplication()) {
          _cacheChildrenSpecificAccess.add(_5.attemptAllowWriteDataInTransit);
        }
        for (var _6 : _clientApplicationConnectionsApplication()) {
          _cacheChildrenSpecificAccess.add(_6.attemptAllowDenyDataInTransit);
        }
        _cacheChildrenSpecificAccess.add(attemptApplicationRespondConnectThroughData);
        _cacheChildrenSpecificAccess.add(accessNetworkAndConnections);
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccess == null) {
        _cacheParentSpecificAccess = new HashSet<>();
        _cacheParentSpecificAccess.add(specificAccessFromLocalConnection);
        _cacheParentSpecificAccess.add(specificAccessFromNetworkConnection);
        _cacheParentSpecificAccess.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccess");
    }
  }

  public class AttemptLocalConnectVulnOnHost extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptLocalConnectVulnOnHost;

    private Set<AttackStep> _cacheParentAttemptLocalConnectVulnOnHost;

    public AttemptLocalConnectVulnOnHost(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptLocalConnectVulnOnHost == null) {
        _cacheChildrenAttemptLocalConnectVulnOnHost = new HashSet<>();
        if (hostApp != null) {
          _cacheChildrenAttemptLocalConnectVulnOnHost.add(hostApp.attemptUseVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAttemptLocalConnectVulnOnHost) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptLocalConnectVulnOnHost == null) {
        _cacheParentAttemptLocalConnectVulnOnHost = new HashSet<>();
        _cacheParentAttemptLocalConnectVulnOnHost.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptLocalConnectVulnOnHost) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptLocalConnectVulnOnHost");
    }
  }

  public class Authenticate extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthenticate;

    private Set<AttackStep> _cacheParentAuthenticate;

    public Authenticate(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthenticate == null) {
        _cacheChildrenAuthenticate = new HashSet<>();
        _cacheChildrenAuthenticate.add(localAccess);
        _cacheChildrenAuthenticate.add(networkAccess);
        for (var _0 : _allVulnerabilitiesApplication()) {
          _cacheChildrenAuthenticate.add(_0.highPrivilegesAchieved);
        }
        _cacheChildrenAuthenticate.add(softwareProductVulnerabilityHighPrivilegesAchieved);
      }
      for (AttackStep attackStep : _cacheChildrenAuthenticate) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthenticate == null) {
        _cacheParentAuthenticate = new HashSet<>();
        for (IAMObject _1 : executionPrivIAMs) {
          _cacheParentAuthenticate.add(_1.assume);
        }
        for (IAMObject _2 : highPrivAppIAMs) {
          _cacheParentAuthenticate.add(_2.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentAuthenticate) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.authenticate");
    }
  }

  public class SpecificAccessAuthenticate extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSpecificAccessAuthenticate;

    private Set<AttackStep> _cacheParentSpecificAccessAuthenticate;

    public SpecificAccessAuthenticate(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessAuthenticate == null) {
        _cacheChildrenSpecificAccessAuthenticate = new HashSet<>();
        _cacheChildrenSpecificAccessAuthenticate.add(specificAccessFromLocalConnection);
        _cacheChildrenSpecificAccessAuthenticate.add(specificAccessFromNetworkConnection);
        for (var _0 : _allVulnerabilitiesApplication()) {
          _cacheChildrenSpecificAccessAuthenticate.add(_0.lowPrivilegesAchieved);
        }
        _cacheChildrenSpecificAccessAuthenticate.add(softwareProductVulnerabilityLowPrivilegesAchieved);
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessAuthenticate) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessAuthenticate == null) {
        _cacheParentSpecificAccessAuthenticate = new HashSet<>();
        for (IAMObject _1 : lowPrivAppIAMs) {
          _cacheParentSpecificAccessAuthenticate.add(_1.assume);
        }
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessAuthenticate) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessAuthenticate");
    }
  }

  public class LocalAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenLocalAccess;

    private Set<AttackStep> _cacheParentLocalAccess;

    public LocalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenLocalAccess == null) {
        _cacheChildrenLocalAccess = new HashSet<>();
        _cacheChildrenLocalAccess.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenLocalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentLocalAccess == null) {
        _cacheParentLocalAccess = new HashSet<>();
        _cacheParentLocalAccess.add(disabled.disable);
        _cacheParentLocalAccess.add(localConnect);
        _cacheParentLocalAccess.add(authenticate);
      }
      for (AttackStep attackStep : _cacheParentLocalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.localAccess");
    }
  }

  public class NetworkAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenNetworkAccess;

    private Set<AttackStep> _cacheParentNetworkAccess;

    public NetworkAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkAccess == null) {
        _cacheChildrenNetworkAccess = new HashSet<>();
        _cacheChildrenNetworkAccess.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkAccess == null) {
        _cacheParentNetworkAccess = new HashSet<>();
        _cacheParentNetworkAccess.add(disabled.disable);
        _cacheParentNetworkAccess.add(networkConnectWithoutTriggeringVulnerabilities);
        _cacheParentNetworkAccess.add(authenticate);
      }
      for (AttackStep attackStep : _cacheParentNetworkAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkAccess");
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
        _cacheChildrenFullAccess.add(attemptRead);
        _cacheChildrenFullAccess.add(attemptModify);
        _cacheChildrenFullAccess.add(attemptDeny);
        for (Application _0 : appExecutedApps) {
          _cacheChildrenFullAccess.add(_0.attemptModify);
        }
        for (IAMObject _1 : executionPrivIAMs) {
          _cacheChildrenFullAccess.add(_1.attemptAssume);
        }
        for (Data _2 : containedData) {
          _cacheChildrenFullAccess.add(_2.attemptAccess);
        }
        for (Data _3 : sentData) {
          _cacheChildrenFullAccess.add(_3.attemptRead);
        }
        for (Data _4 : receivedData) {
          _cacheChildrenFullAccess.add(_4.attemptRead);
        }
        for (Data _5 : sentData) {
          _cacheChildrenFullAccess.add(_5.attemptWriteDataInTransitFromApplication);
        }
        for (var _6 : _clientApplicationConnectionsApplication()) {
          _cacheChildrenFullAccess.add(_6.attemptAllowWriteDataInTransit);
        }
        for (var _7 : _clientApplicationConnectionsApplication()) {
          _cacheChildrenFullAccess.add(_7.attemptAllowDenyDataInTransit);
        }
        _cacheChildrenFullAccess.add(attemptApplicationRespondConnectThroughData);
        _cacheChildrenFullAccess.add(accessNetworkAndConnections);
        if (hostApp != null) {
          _cacheChildrenFullAccess.add(hostApp.localConnect);
        }
        for (RoutingFirewall _8 : managedRoutingFw) {
          _cacheChildrenFullAccess.add(_8.attemptModify);
        }
        _cacheChildrenFullAccess.add(specificAccess);
        if (hostHardware != null) {
          _cacheChildrenFullAccess.add(hostHardware.attemptUseVulnerability);
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
        if (hostHardware != null) {
          _cacheParentFullAccess.add(hostHardware.fullAccess);
        }
        _cacheParentFullAccess.add(localAccess);
        _cacheParentFullAccess.add(networkAccess);
        _cacheParentFullAccess.add(fullAccessAfterSoftProdCompromise);
        _cacheParentFullAccess.add(fullAccessAfterSoftProdVulnerability);
        _cacheParentFullAccess.add(modify);
      }
      for (AttackStep attackStep : _cacheParentFullAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.fullAccess");
    }
  }

  public class PhysicalAccessAchieved extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenPhysicalAccessAchieved;

    private Set<AttackStep> _cacheParentPhysicalAccessAchieved;

    public PhysicalAccessAchieved(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenPhysicalAccessAchieved == null) {
        _cacheChildrenPhysicalAccessAchieved = new HashSet<>();
        for (var _0 : _allVulnerabilitiesApplication()) {
          _cacheChildrenPhysicalAccessAchieved.add(_0.physicalAccessAchieved);
        }
        _cacheChildrenPhysicalAccessAchieved.add(softwareProductVulnerabilityPhysicalAccessAchieved);
        for (Application _1 : appExecutedApps) {
          _cacheChildrenPhysicalAccessAchieved.add(_1.physicalAccessAchieved);
        }
      }
      for (AttackStep attackStep : _cacheChildrenPhysicalAccessAchieved) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentPhysicalAccessAchieved == null) {
        _cacheParentPhysicalAccessAchieved = new HashSet<>();
        if (hostHardware != null) {
          _cacheParentPhysicalAccessAchieved.add(hostHardware.hardwareModifications);
        }
        if (hostHardware != null) {
          _cacheParentPhysicalAccessAchieved.add(hostHardware.unsafeUserActivity);
        }
        if (hostApp != null) {
          _cacheParentPhysicalAccessAchieved.add(hostApp.physicalAccessAchieved);
        }
      }
      for (AttackStep attackStep : _cacheParentPhysicalAccessAchieved) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.physicalAccessAchieved");
    }
  }

  public class AttemptUnsafeActivityByUser extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptUnsafeActivityByUser;

    private Set<AttackStep> _cacheParentAttemptUnsafeActivityByUser;

    public AttemptUnsafeActivityByUser(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptUnsafeActivityByUser == null) {
        _cacheChildrenAttemptUnsafeActivityByUser = new HashSet<>();
        _cacheChildrenAttemptUnsafeActivityByUser.add(unsafeActivityByUser);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptUnsafeActivityByUser) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptUnsafeActivityByUser == null) {
        _cacheParentAttemptUnsafeActivityByUser = new HashSet<>();
        _cacheParentAttemptUnsafeActivityByUser.add(unsafeUserActivityWithAttackerInteraction);
        _cacheParentAttemptUnsafeActivityByUser.add(unsafeUserActivityWithoutAttackerInteraction);
      }
      for (AttackStep attackStep : _cacheParentAttemptUnsafeActivityByUser) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptUnsafeActivityByUser");
    }
  }

  public class UnsafeActivityByUser extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenUnsafeActivityByUser;

    private Set<AttackStep> _cacheParentUnsafeActivityByUser;

    public UnsafeActivityByUser(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUnsafeActivityByUser == null) {
        _cacheChildrenUnsafeActivityByUser = new HashSet<>();
        _cacheChildrenUnsafeActivityByUser.add(localConnect);
        _cacheChildrenUnsafeActivityByUser.add(networkConnect);
        for (var _0 : _allVulnerabilitiesApplication()) {
          _cacheChildrenUnsafeActivityByUser.add(_0.userInteractionAchieved);
        }
      }
      for (AttackStep attackStep : _cacheChildrenUnsafeActivityByUser) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUnsafeActivityByUser == null) {
        _cacheParentUnsafeActivityByUser = new HashSet<>();
        _cacheParentUnsafeActivityByUser.add(attemptUnsafeActivityByUser);
        for (IDPS _1 : protectorIDPSs) {
          _cacheParentUnsafeActivityByUser.add(_1.protectionBypassed);
        }
      }
      for (AttackStep attackStep : _cacheParentUnsafeActivityByUser) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.unsafeActivityByUser");
    }
  }

  public class UnsafeUserActivityWithAttackerInteraction extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenUnsafeUserActivityWithAttackerInteraction;

    private Set<AttackStep> _cacheParentUnsafeUserActivityWithAttackerInteraction;

    public UnsafeUserActivityWithAttackerInteraction(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUnsafeUserActivityWithAttackerInteraction == null) {
        _cacheChildrenUnsafeUserActivityWithAttackerInteraction = new HashSet<>();
        _cacheChildrenUnsafeUserActivityWithAttackerInteraction.add(attemptUnsafeActivityByUser);
      }
      for (AttackStep attackStep : _cacheChildrenUnsafeUserActivityWithAttackerInteraction) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUnsafeUserActivityWithAttackerInteraction == null) {
        _cacheParentUnsafeUserActivityWithAttackerInteraction = new HashSet<>();
        _cacheParentUnsafeUserActivityWithAttackerInteraction.add(reverseReach);
        _cacheParentUnsafeUserActivityWithAttackerInteraction.add(attemptUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheParentUnsafeUserActivityWithAttackerInteraction) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.unsafeUserActivityWithAttackerInteraction");
    }
  }

  public class UnsafeUserActivityWithoutAttackerInteraction extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenUnsafeUserActivityWithoutAttackerInteraction;

    private Set<AttackStep> _cacheParentUnsafeUserActivityWithoutAttackerInteraction;

    public UnsafeUserActivityWithoutAttackerInteraction(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenUnsafeUserActivityWithoutAttackerInteraction == null) {
        _cacheChildrenUnsafeUserActivityWithoutAttackerInteraction = new HashSet<>();
        _cacheChildrenUnsafeUserActivityWithoutAttackerInteraction.add(attemptUnsafeActivityByUser);
      }
      for (AttackStep attackStep : _cacheChildrenUnsafeUserActivityWithoutAttackerInteraction) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentUnsafeUserActivityWithoutAttackerInteraction == null) {
        _cacheParentUnsafeUserActivityWithoutAttackerInteraction = new HashSet<>();
        _cacheParentUnsafeUserActivityWithoutAttackerInteraction.add(attemptUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheParentUnsafeUserActivityWithoutAttackerInteraction) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.unsafeUserActivityWithoutAttackerInteraction");
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
        _cacheChildrenAttemptUnsafeUserActivity.add(unsafeUserActivityWithAttackerInteraction);
        _cacheChildrenAttemptUnsafeUserActivity.add(unsafeUserActivityWithoutAttackerInteraction);
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
        if (hostHardware != null) {
          _cacheParentAttemptUnsafeUserActivity.add(hostHardware.unsafeUserActivity);
        }
        for (IAMObject _0 : executionPrivIAMs) {
          if (_0 instanceof Identity) {
            for (User _1 : ((com.coevolution.corelang_0_5_2.Identity) _0).users) {
              _cacheParentAttemptUnsafeUserActivity.add(_1.unsafeUserActivity);
            }
          }
        }
        for (IAMObject _2 : executionPrivIAMs) {
          if (_2 instanceof Privileges) {
            for (Identity _3 : ((com.coevolution.corelang_0_5_2.Privileges) _2).privilegeIdentities) {
              for (User _4 : _3.users) {
                _cacheParentAttemptUnsafeUserActivity.add(_4.unsafeUserActivity);
              }
            }
          }
        }
        for (IAMObject _5 : highPrivAppIAMs) {
          if (_5 instanceof Identity) {
            for (User _6 : ((com.coevolution.corelang_0_5_2.Identity) _5).users) {
              _cacheParentAttemptUnsafeUserActivity.add(_6.unsafeUserActivity);
            }
          }
        }
        for (IAMObject _7 : highPrivAppIAMs) {
          if (_7 instanceof Privileges) {
            for (Identity _8 : ((com.coevolution.corelang_0_5_2.Privileges) _7).privilegeIdentities) {
              for (User _9 : _8.users) {
                _cacheParentAttemptUnsafeUserActivity.add(_9.unsafeUserActivity);
              }
            }
          }
        }
        for (IAMObject _a : lowPrivAppIAMs) {
          if (_a instanceof Identity) {
            for (User _b : ((com.coevolution.corelang_0_5_2.Identity) _a).users) {
              _cacheParentAttemptUnsafeUserActivity.add(_b.unsafeUserActivity);
            }
          }
        }
        for (IAMObject _c : lowPrivAppIAMs) {
          if (_c instanceof Privileges) {
            for (Identity _d : ((com.coevolution.corelang_0_5_2.Privileges) _c).privilegeIdentities) {
              for (User _e : _d.users) {
                _cacheParentAttemptUnsafeUserActivity.add(_e.unsafeUserActivity);
              }
            }
          }
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptUnsafeUserActivity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptUnsafeUserActivity");
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
          _cacheChildrenSupplyChainAuditing.add(fullAccessAfterSoftProdCompromise);
        }
        for (AttackStep attackStep : _cacheChildrenSupplyChainAuditing) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Application.supplyChainAuditing";
      }
    }
  }

  public class AttemptFullAccessAfterSoftProdCompromise extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptFullAccessAfterSoftProdCompromise;

    private Set<AttackStep> _cacheParentAttemptFullAccessAfterSoftProdCompromise;

    public AttemptFullAccessAfterSoftProdCompromise(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptFullAccessAfterSoftProdCompromise == null) {
        _cacheChildrenAttemptFullAccessAfterSoftProdCompromise = new HashSet<>();
        _cacheChildrenAttemptFullAccessAfterSoftProdCompromise.add(fullAccessAfterSoftProdCompromise);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptFullAccessAfterSoftProdCompromise) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptFullAccessAfterSoftProdCompromise == null) {
        _cacheParentAttemptFullAccessAfterSoftProdCompromise = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptFullAccessAfterSoftProdCompromise.add(appSoftProduct.compromiseApplication);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptFullAccessAfterSoftProdCompromise) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptFullAccessAfterSoftProdCompromise");
    }
  }

  public class FullAccessAfterSoftProdCompromise extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenFullAccessAfterSoftProdCompromise;

    private Set<AttackStep> _cacheParentFullAccessAfterSoftProdCompromise;

    public FullAccessAfterSoftProdCompromise(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenFullAccessAfterSoftProdCompromise == null) {
        _cacheChildrenFullAccessAfterSoftProdCompromise = new HashSet<>();
        _cacheChildrenFullAccessAfterSoftProdCompromise.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenFullAccessAfterSoftProdCompromise) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentFullAccessAfterSoftProdCompromise == null) {
        _cacheParentFullAccessAfterSoftProdCompromise = new HashSet<>();
        _cacheParentFullAccessAfterSoftProdCompromise.add(supplyChainAuditing.disable);
        _cacheParentFullAccessAfterSoftProdCompromise.add(attemptFullAccessAfterSoftProdCompromise);
      }
      for (AttackStep attackStep : _cacheParentFullAccessAfterSoftProdCompromise) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.fullAccessAfterSoftProdCompromise");
    }
  }

  public class AttemptFullAccessAfterSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptFullAccessAfterSoftProdVulnerability;

    public AttemptFullAccessAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptFullAccessAfterSoftProdVulnerability == null) {
        _cacheChildrenAttemptFullAccessAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptFullAccessAfterSoftProdVulnerability.add(fullAccessAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptFullAccessAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptFullAccessAfterSoftProdVulnerability");
    }
  }

  public class AttemptReadAfterSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptReadAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptReadAfterSoftProdVulnerability;

    public AttemptReadAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptReadAfterSoftProdVulnerability == null) {
        _cacheChildrenAttemptReadAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptReadAfterSoftProdVulnerability.add(readAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptReadAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptReadAfterSoftProdVulnerability == null) {
        _cacheParentAttemptReadAfterSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptReadAfterSoftProdVulnerability.add(appSoftProduct.readApplication);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptReadAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptReadAfterSoftProdVulnerability");
    }
  }

  public class AttemptModifyAfterSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptModifyAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptModifyAfterSoftProdVulnerability;

    public AttemptModifyAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptModifyAfterSoftProdVulnerability == null) {
        _cacheChildrenAttemptModifyAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptModifyAfterSoftProdVulnerability.add(modifyAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptModifyAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptModifyAfterSoftProdVulnerability == null) {
        _cacheParentAttemptModifyAfterSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptModifyAfterSoftProdVulnerability.add(appSoftProduct.modifyApplication);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptModifyAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptModifyAfterSoftProdVulnerability");
    }
  }

  public class AttemptDenyAfterSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDenyAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptDenyAfterSoftProdVulnerability;

    public AttemptDenyAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDenyAfterSoftProdVulnerability == null) {
        _cacheChildrenAttemptDenyAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptDenyAfterSoftProdVulnerability.add(denyAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDenyAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDenyAfterSoftProdVulnerability == null) {
        _cacheParentAttemptDenyAfterSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptDenyAfterSoftProdVulnerability.add(appSoftProduct.denyApplication);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDenyAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptDenyAfterSoftProdVulnerability");
    }
  }

  public class SoftwareCheck extends Defense {
    public SoftwareCheck(String name) {
      super(name);
      disable = new Disable(name);
    }

    @Override
    public boolean isEnabled() {
      if (appSoftProduct != null) {
        return false;
      }
      return true;
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenSoftwareCheck;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenSoftwareCheck == null) {
          _cacheChildrenSoftwareCheck = new HashSet<>();
          _cacheChildrenSoftwareCheck.add(fullAccessAfterSoftProdVulnerability);
          _cacheChildrenSoftwareCheck.add(readAfterSoftProdVulnerability);
          _cacheChildrenSoftwareCheck.add(modifyAfterSoftProdVulnerability);
          _cacheChildrenSoftwareCheck.add(denyAfterSoftProdVulnerability);
        }
        for (AttackStep attackStep : _cacheChildrenSoftwareCheck) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Application.softwareCheck";
      }
    }
  }

  public class SoftwareProductVulnerabilityLocalAccessAchieved extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSoftwareProductVulnerabilityLocalAccessAchieved;

    private Set<AttackStep> _cacheParentSoftwareProductVulnerabilityLocalAccessAchieved;

    public SoftwareProductVulnerabilityLocalAccessAchieved(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSoftwareProductVulnerabilityLocalAccessAchieved == null) {
        _cacheChildrenSoftwareProductVulnerabilityLocalAccessAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _0 : appSoftProduct.softProductVulnerabilities) {
            _cacheChildrenSoftwareProductVulnerabilityLocalAccessAchieved.add(_0.localAccessAchieved);
          }
        }
        _cacheChildrenSoftwareProductVulnerabilityLocalAccessAchieved.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheChildrenSoftwareProductVulnerabilityLocalAccessAchieved) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSoftwareProductVulnerabilityLocalAccessAchieved == null) {
        _cacheParentSoftwareProductVulnerabilityLocalAccessAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityLocalAccessAchieved.add(_1.localAccessRequired.disable);
          }
        }
        _cacheParentSoftwareProductVulnerabilityLocalAccessAchieved.add(localConnect);
      }
      for (AttackStep attackStep : _cacheParentSoftwareProductVulnerabilityLocalAccessAchieved) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.softwareProductVulnerabilityLocalAccessAchieved");
    }
  }

  public class SoftwareProductVulnerabilityNetworkAccessAchieved extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSoftwareProductVulnerabilityNetworkAccessAchieved;

    private Set<AttackStep> _cacheParentSoftwareProductVulnerabilityNetworkAccessAchieved;

    public SoftwareProductVulnerabilityNetworkAccessAchieved(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSoftwareProductVulnerabilityNetworkAccessAchieved == null) {
        _cacheChildrenSoftwareProductVulnerabilityNetworkAccessAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _0 : appSoftProduct.softProductVulnerabilities) {
            _cacheChildrenSoftwareProductVulnerabilityNetworkAccessAchieved.add(_0.networkAccessAchieved);
          }
        }
        _cacheChildrenSoftwareProductVulnerabilityNetworkAccessAchieved.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheChildrenSoftwareProductVulnerabilityNetworkAccessAchieved) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSoftwareProductVulnerabilityNetworkAccessAchieved == null) {
        _cacheParentSoftwareProductVulnerabilityNetworkAccessAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityNetworkAccessAchieved.add(_1.networkAccessRequired.disable);
          }
        }
        _cacheParentSoftwareProductVulnerabilityNetworkAccessAchieved.add(networkConnect);
      }
      for (AttackStep attackStep : _cacheParentSoftwareProductVulnerabilityNetworkAccessAchieved) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.softwareProductVulnerabilityNetworkAccessAchieved");
    }
  }

  public class SoftwareProductVulnerabilityPhysicalAccessAchieved extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSoftwareProductVulnerabilityPhysicalAccessAchieved;

    private Set<AttackStep> _cacheParentSoftwareProductVulnerabilityPhysicalAccessAchieved;

    public SoftwareProductVulnerabilityPhysicalAccessAchieved(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSoftwareProductVulnerabilityPhysicalAccessAchieved == null) {
        _cacheChildrenSoftwareProductVulnerabilityPhysicalAccessAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _0 : appSoftProduct.softProductVulnerabilities) {
            _cacheChildrenSoftwareProductVulnerabilityPhysicalAccessAchieved.add(_0.physicalAccessAchieved);
          }
        }
        _cacheChildrenSoftwareProductVulnerabilityPhysicalAccessAchieved.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheChildrenSoftwareProductVulnerabilityPhysicalAccessAchieved) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSoftwareProductVulnerabilityPhysicalAccessAchieved == null) {
        _cacheParentSoftwareProductVulnerabilityPhysicalAccessAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityPhysicalAccessAchieved.add(_1.physicalAccessRequired.disable);
          }
        }
        _cacheParentSoftwareProductVulnerabilityPhysicalAccessAchieved.add(physicalAccessAchieved);
      }
      for (AttackStep attackStep : _cacheParentSoftwareProductVulnerabilityPhysicalAccessAchieved) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.softwareProductVulnerabilityPhysicalAccessAchieved");
    }
  }

  public class SoftwareProductVulnerabilityLowPrivilegesAchieved extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSoftwareProductVulnerabilityLowPrivilegesAchieved;

    private Set<AttackStep> _cacheParentSoftwareProductVulnerabilityLowPrivilegesAchieved;

    public SoftwareProductVulnerabilityLowPrivilegesAchieved(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSoftwareProductVulnerabilityLowPrivilegesAchieved == null) {
        _cacheChildrenSoftwareProductVulnerabilityLowPrivilegesAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _0 : appSoftProduct.softProductVulnerabilities) {
            _cacheChildrenSoftwareProductVulnerabilityLowPrivilegesAchieved.add(_0.lowPrivilegesAchieved);
          }
        }
        _cacheChildrenSoftwareProductVulnerabilityLowPrivilegesAchieved.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheChildrenSoftwareProductVulnerabilityLowPrivilegesAchieved) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSoftwareProductVulnerabilityLowPrivilegesAchieved == null) {
        _cacheParentSoftwareProductVulnerabilityLowPrivilegesAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityLowPrivilegesAchieved.add(_1.lowPrivilegesRequired.disable);
          }
        }
        _cacheParentSoftwareProductVulnerabilityLowPrivilegesAchieved.add(specificAccessAuthenticate);
      }
      for (AttackStep attackStep : _cacheParentSoftwareProductVulnerabilityLowPrivilegesAchieved) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.softwareProductVulnerabilityLowPrivilegesAchieved");
    }
  }

  public class SoftwareProductVulnerabilityHighPrivilegesAchieved extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSoftwareProductVulnerabilityHighPrivilegesAchieved;

    private Set<AttackStep> _cacheParentSoftwareProductVulnerabilityHighPrivilegesAchieved;

    public SoftwareProductVulnerabilityHighPrivilegesAchieved(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSoftwareProductVulnerabilityHighPrivilegesAchieved == null) {
        _cacheChildrenSoftwareProductVulnerabilityHighPrivilegesAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _0 : appSoftProduct.softProductVulnerabilities) {
            _cacheChildrenSoftwareProductVulnerabilityHighPrivilegesAchieved.add(_0.highPrivilegesAchieved);
          }
        }
        _cacheChildrenSoftwareProductVulnerabilityHighPrivilegesAchieved.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheChildrenSoftwareProductVulnerabilityHighPrivilegesAchieved) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSoftwareProductVulnerabilityHighPrivilegesAchieved == null) {
        _cacheParentSoftwareProductVulnerabilityHighPrivilegesAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityHighPrivilegesAchieved.add(_1.highPrivilegesRequired.disable);
          }
        }
        _cacheParentSoftwareProductVulnerabilityHighPrivilegesAchieved.add(authenticate);
      }
      for (AttackStep attackStep : _cacheParentSoftwareProductVulnerabilityHighPrivilegesAchieved) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.softwareProductVulnerabilityHighPrivilegesAchieved");
    }
  }

  public class SoftwareProductVulnerabilityUserInteractionAchieved extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSoftwareProductVulnerabilityUserInteractionAchieved;

    private Set<AttackStep> _cacheParentSoftwareProductVulnerabilityUserInteractionAchieved;

    public SoftwareProductVulnerabilityUserInteractionAchieved(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSoftwareProductVulnerabilityUserInteractionAchieved == null) {
        _cacheChildrenSoftwareProductVulnerabilityUserInteractionAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _0 : appSoftProduct.softProductVulnerabilities) {
            _cacheChildrenSoftwareProductVulnerabilityUserInteractionAchieved.add(_0.userInteractionAchieved);
          }
        }
        _cacheChildrenSoftwareProductVulnerabilityUserInteractionAchieved.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheChildrenSoftwareProductVulnerabilityUserInteractionAchieved) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSoftwareProductVulnerabilityUserInteractionAchieved == null) {
        _cacheParentSoftwareProductVulnerabilityUserInteractionAchieved = new HashSet<>();
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityUserInteractionAchieved.add(_1.userInteractionRequired.disable);
          }
        }
      }
      for (AttackStep attackStep : _cacheParentSoftwareProductVulnerabilityUserInteractionAchieved) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.softwareProductVulnerabilityUserInteractionAchieved");
    }
  }

  public class AttemptSoftwareProductAbuse extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptSoftwareProductAbuse;

    private Set<AttackStep> _cacheParentAttemptSoftwareProductAbuse;

    public AttemptSoftwareProductAbuse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptSoftwareProductAbuse == null) {
        _cacheChildrenAttemptSoftwareProductAbuse = new HashSet<>();
        _cacheChildrenAttemptSoftwareProductAbuse.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptSoftwareProductAbuse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptSoftwareProductAbuse == null) {
        _cacheParentAttemptSoftwareProductAbuse = new HashSet<>();
        _cacheParentAttemptSoftwareProductAbuse.add(useVulnerability);
      }
      for (AttackStep attackStep : _cacheParentAttemptSoftwareProductAbuse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptSoftwareProductAbuse");
    }
  }

  public class SoftwareProductAbuse extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSoftwareProductAbuse;

    private Set<AttackStep> _cacheParentSoftwareProductAbuse;

    public SoftwareProductAbuse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSoftwareProductAbuse == null) {
        _cacheChildrenSoftwareProductAbuse = new HashSet<>();
        _cacheChildrenSoftwareProductAbuse.add(fullAccessAfterSoftProdVulnerability);
        _cacheChildrenSoftwareProductAbuse.add(readAfterSoftProdVulnerability);
        _cacheChildrenSoftwareProductAbuse.add(modifyAfterSoftProdVulnerability);
        _cacheChildrenSoftwareProductAbuse.add(denyAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenSoftwareProductAbuse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSoftwareProductAbuse == null) {
        _cacheParentSoftwareProductAbuse = new HashSet<>();
        _cacheParentSoftwareProductAbuse.add(softwareProductVulnerabilityLocalAccessAchieved);
        _cacheParentSoftwareProductAbuse.add(softwareProductVulnerabilityNetworkAccessAchieved);
        _cacheParentSoftwareProductAbuse.add(softwareProductVulnerabilityPhysicalAccessAchieved);
        _cacheParentSoftwareProductAbuse.add(softwareProductVulnerabilityLowPrivilegesAchieved);
        _cacheParentSoftwareProductAbuse.add(softwareProductVulnerabilityHighPrivilegesAchieved);
        _cacheParentSoftwareProductAbuse.add(softwareProductVulnerabilityUserInteractionAchieved);
        _cacheParentSoftwareProductAbuse.add(attemptSoftwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheParentSoftwareProductAbuse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.softwareProductAbuse");
    }
  }

  public class FullAccessAfterSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenFullAccessAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentFullAccessAfterSoftProdVulnerability;

    public FullAccessAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenFullAccessAfterSoftProdVulnerability == null) {
        _cacheChildrenFullAccessAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenFullAccessAfterSoftProdVulnerability.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenFullAccessAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentFullAccessAfterSoftProdVulnerability == null) {
        _cacheParentFullAccessAfterSoftProdVulnerability = new HashSet<>();
        _cacheParentFullAccessAfterSoftProdVulnerability.add(disabled.disable);
        _cacheParentFullAccessAfterSoftProdVulnerability.add(useVulnerability);
        _cacheParentFullAccessAfterSoftProdVulnerability.add(attemptFullAccessAfterSoftProdVulnerability);
        _cacheParentFullAccessAfterSoftProdVulnerability.add(softwareCheck.disable);
        _cacheParentFullAccessAfterSoftProdVulnerability.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheParentFullAccessAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.fullAccessAfterSoftProdVulnerability");
    }
  }

  public class ReadAfterSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenReadAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentReadAfterSoftProdVulnerability;

    public ReadAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReadAfterSoftProdVulnerability == null) {
        _cacheChildrenReadAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenReadAfterSoftProdVulnerability.add(attemptRead);
      }
      for (AttackStep attackStep : _cacheChildrenReadAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReadAfterSoftProdVulnerability == null) {
        _cacheParentReadAfterSoftProdVulnerability = new HashSet<>();
        _cacheParentReadAfterSoftProdVulnerability.add(disabled.disable);
        _cacheParentReadAfterSoftProdVulnerability.add(useVulnerability);
        _cacheParentReadAfterSoftProdVulnerability.add(attemptReadAfterSoftProdVulnerability);
        _cacheParentReadAfterSoftProdVulnerability.add(softwareCheck.disable);
        _cacheParentReadAfterSoftProdVulnerability.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheParentReadAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.readAfterSoftProdVulnerability");
    }
  }

  public class ModifyAfterSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenModifyAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentModifyAfterSoftProdVulnerability;

    public ModifyAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenModifyAfterSoftProdVulnerability == null) {
        _cacheChildrenModifyAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenModifyAfterSoftProdVulnerability.add(attemptModify);
      }
      for (AttackStep attackStep : _cacheChildrenModifyAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentModifyAfterSoftProdVulnerability == null) {
        _cacheParentModifyAfterSoftProdVulnerability = new HashSet<>();
        _cacheParentModifyAfterSoftProdVulnerability.add(disabled.disable);
        _cacheParentModifyAfterSoftProdVulnerability.add(useVulnerability);
        _cacheParentModifyAfterSoftProdVulnerability.add(attemptModifyAfterSoftProdVulnerability);
        _cacheParentModifyAfterSoftProdVulnerability.add(softwareCheck.disable);
        _cacheParentModifyAfterSoftProdVulnerability.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheParentModifyAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.modifyAfterSoftProdVulnerability");
    }
  }

  public class DenyAfterSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDenyAfterSoftProdVulnerability;

    private Set<AttackStep> _cacheParentDenyAfterSoftProdVulnerability;

    public DenyAfterSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyAfterSoftProdVulnerability == null) {
        _cacheChildrenDenyAfterSoftProdVulnerability = new HashSet<>();
        _cacheChildrenDenyAfterSoftProdVulnerability.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheChildrenDenyAfterSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyAfterSoftProdVulnerability == null) {
        _cacheParentDenyAfterSoftProdVulnerability = new HashSet<>();
        _cacheParentDenyAfterSoftProdVulnerability.add(disabled.disable);
        _cacheParentDenyAfterSoftProdVulnerability.add(useVulnerability);
        _cacheParentDenyAfterSoftProdVulnerability.add(attemptDenyAfterSoftProdVulnerability);
        _cacheParentDenyAfterSoftProdVulnerability.add(softwareCheck.disable);
        _cacheParentDenyAfterSoftProdVulnerability.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheParentDenyAfterSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.denyAfterSoftProdVulnerability");
    }
  }

  public class AttemptApplicationRespondConnectThroughData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptApplicationRespondConnectThroughData;

    private Set<AttackStep> _cacheParentAttemptApplicationRespondConnectThroughData;

    public AttemptApplicationRespondConnectThroughData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptApplicationRespondConnectThroughData == null) {
        _cacheChildrenAttemptApplicationRespondConnectThroughData = new HashSet<>();
        _cacheChildrenAttemptApplicationRespondConnectThroughData.add(successfulApplicationRespondConnectThroughData);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptApplicationRespondConnectThroughData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptApplicationRespondConnectThroughData == null) {
        _cacheParentAttemptApplicationRespondConnectThroughData = new HashSet<>();
        _cacheParentAttemptApplicationRespondConnectThroughData.add(specificAccess);
        _cacheParentAttemptApplicationRespondConnectThroughData.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptApplicationRespondConnectThroughData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptApplicationRespondConnectThroughData");
    }
  }

  public class SuccessfulApplicationRespondConnectThroughData extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulApplicationRespondConnectThroughData;

    private Set<AttackStep> _cacheParentSuccessfulApplicationRespondConnectThroughData;

    public SuccessfulApplicationRespondConnectThroughData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulApplicationRespondConnectThroughData == null) {
        _cacheChildrenSuccessfulApplicationRespondConnectThroughData = new HashSet<>();
        _cacheChildrenSuccessfulApplicationRespondConnectThroughData.add(applicationRespondConnectThroughData);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulApplicationRespondConnectThroughData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulApplicationRespondConnectThroughData == null) {
        _cacheParentSuccessfulApplicationRespondConnectThroughData = new HashSet<>();
        _cacheParentSuccessfulApplicationRespondConnectThroughData.add(disabled.disable);
        _cacheParentSuccessfulApplicationRespondConnectThroughData.add(attemptApplicationRespondConnectThroughData);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulApplicationRespondConnectThroughData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.successfulApplicationRespondConnectThroughData");
    }
  }

  public class ApplicationRespondConnectThroughData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenApplicationRespondConnectThroughData;

    private Set<AttackStep> _cacheParentApplicationRespondConnectThroughData;

    public ApplicationRespondConnectThroughData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenApplicationRespondConnectThroughData == null) {
        _cacheChildrenApplicationRespondConnectThroughData = new HashSet<>();
        for (Data _0 : receivedData) {
          _cacheChildrenApplicationRespondConnectThroughData.add(_0.attemptApplicationRespondConnect);
        }
      }
      for (AttackStep attackStep : _cacheChildrenApplicationRespondConnectThroughData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentApplicationRespondConnectThroughData == null) {
        _cacheParentApplicationRespondConnectThroughData = new HashSet<>();
        _cacheParentApplicationRespondConnectThroughData.add(successfulApplicationRespondConnectThroughData);
      }
      for (AttackStep attackStep : _cacheParentApplicationRespondConnectThroughData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.applicationRespondConnectThroughData");
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
        if (hostHardware != null) {
          _cacheParentAttemptRead.add(hostHardware.read);
        }
        _cacheParentAttemptRead.add(fullAccess);
        _cacheParentAttemptRead.add(readAfterSoftProdVulnerability);
        if (hostApp != null) {
          _cacheParentAttemptRead.add(hostApp.read);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptRead");
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
        _cacheParentSuccessfulRead.add(disabled.disable);
        _cacheParentSuccessfulRead.add(attemptRead);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.successfulRead");
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
        for (Application _1 : appExecutedApps) {
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
        for (SoftwareVulnerability _2 : vulnerabilities) {
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
      return ttcHashMap.get("Application.read");
    }
  }

  public class AttemptModify extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptModify;

    private Set<AttackStep> _cacheParentAttemptModify;

    public AttemptModify(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptModify == null) {
        _cacheChildrenAttemptModify = new HashSet<>();
        _cacheChildrenAttemptModify.add(successfulModify);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptModify) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptModify == null) {
        _cacheParentAttemptModify = new HashSet<>();
        if (hostHardware != null) {
          _cacheParentAttemptModify.add(hostHardware.modify);
        }
        _cacheParentAttemptModify.add(fullAccess);
        if (hostApp != null) {
          _cacheParentAttemptModify.add(hostApp.fullAccess);
        }
        if (Application.this instanceof RoutingFirewall) {
          if (((com.coevolution.corelang_0_5_2.RoutingFirewall) Application.this).managerApp != null) {
            _cacheParentAttemptModify.add(((com.coevolution.corelang_0_5_2.RoutingFirewall) Application.this).managerApp.fullAccess);
          }
        }
        _cacheParentAttemptModify.add(modifyAfterSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheParentAttemptModify) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptModify");
    }
  }

  public class SuccessfulModify extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulModify;

    private Set<AttackStep> _cacheParentSuccessfulModify;

    public SuccessfulModify(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulModify == null) {
        _cacheChildrenSuccessfulModify = new HashSet<>();
        _cacheChildrenSuccessfulModify.add(modify);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulModify) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulModify == null) {
        _cacheParentSuccessfulModify = new HashSet<>();
        _cacheParentSuccessfulModify.add(disabled.disable);
        _cacheParentSuccessfulModify.add(attemptModify);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulModify) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.successfulModify");
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
        for (Data _0 : containedData) {
          _cacheChildrenModify.add(_0.attemptAccess);
        }
        _cacheChildrenModify.add(fullAccess);
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
        for (SoftwareVulnerability _1 : vulnerabilities) {
          _cacheParentModify.add(_1.modify);
        }
        _cacheParentModify.add(successfulModify);
      }
      for (AttackStep attackStep : _cacheParentModify) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.modify");
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
        if (hostHardware != null) {
          _cacheParentAttemptDeny.add(hostHardware.deny);
        }
        _cacheParentAttemptDeny.add(fullAccess);
        _cacheParentAttemptDeny.add(denyAfterSoftProdVulnerability);
        if (hostApp != null) {
          _cacheParentAttemptDeny.add(hostApp.deny);
        }
        _cacheParentAttemptDeny.add(denyFromNetworkingAsset);
      }
      for (AttackStep attackStep : _cacheParentAttemptDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptDeny");
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
        _cacheParentSuccessfulDeny.add(disabled.disable);
        _cacheParentSuccessfulDeny.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.successfulDeny");
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
        for (Data _1 : sentData) {
          _cacheChildrenDeny.add(_1.attemptDenyDataInTransitFromApplication);
        }
        for (Application _2 : appExecutedApps) {
          _cacheChildrenDeny.add(_2.attemptDeny);
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
        for (SoftwareVulnerability _3 : vulnerabilities) {
          _cacheParentDeny.add(_3.deny);
        }
        _cacheParentDeny.add(successfulDeny);
      }
      for (AttackStep attackStep : _cacheParentDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.deny");
    }
  }

  public class DenyFromNetworkingAsset extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDenyFromNetworkingAsset;

    private Set<AttackStep> _cacheParentDenyFromNetworkingAsset;

    public DenyFromNetworkingAsset(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyFromNetworkingAsset == null) {
        _cacheChildrenDenyFromNetworkingAsset = new HashSet<>();
        _cacheChildrenDenyFromNetworkingAsset.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheChildrenDenyFromNetworkingAsset) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyFromNetworkingAsset == null) {
        _cacheParentDenyFromNetworkingAsset = new HashSet<>();
        for (var _0 : _reverseallowedApplicationConnectionsApplicationsNetwork()) {
          _cacheParentDenyFromNetworkingAsset.add(_0.denialOfService);
        }
        for (var _1 : _reverseallApplicationsConnectionRule()) {
          _cacheParentDenyFromNetworkingAsset.add(_1.denialOfService);
        }
      }
      for (AttackStep attackStep : _cacheParentDenyFromNetworkingAsset) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.denyFromNetworkingAsset");
    }
  }
}
