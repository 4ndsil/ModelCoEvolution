package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Application extends Asset {
  public NotPresent notPresent;

  public AttemptUseVulnerability attemptUseVulnerability;

  public SuccessfulUseVulnerability successfulUseVulnerability;

  public UseVulnerability useVulnerability;

  public AttemptReverseReach attemptReverseReach;

  public SuccessfulReverseReach successfulReverseReach;

  public ReverseReach reverseReach;

  public LocalConnect localConnect;

  public NetworkConnectUninspected networkConnectUninspected;

  public NetworkConnectInspected networkConnectInspected;

  public NetworkConnect networkConnect;

  public SpecificAccessNetworkConnect specificAccessNetworkConnect;

  public AccessNetworkAndConnections accessNetworkAndConnections;

  public AttemptNetworkConnectFromResponse attemptNetworkConnectFromResponse;

  public NetworkConnectFromResponse networkConnectFromResponse;

  public SpecificAccessFromLocalConnection specificAccessFromLocalConnection;

  public SpecificAccessFromNetworkConnection specificAccessFromNetworkConnection;

  public SpecificAccess specificAccess;

  public BypassContainerization bypassContainerization;

  public Authenticate authenticate;

  public SpecificAccessAuthenticate specificAccessAuthenticate;

  public LocalAccess localAccess;

  public NetworkAccess networkAccess;

  public FullAccess fullAccess;

  public PhysicalAccessAchieved physicalAccessAchieved;

  public AttemptUnsafeUserActivity attemptUnsafeUserActivity;

  public SuccessfulUnsafeUserActivity successfulUnsafeUserActivity;

  public UnsafeUserActivity unsafeUserActivity;

  public AttackerUnsafeUserActivityCapability attackerUnsafeUserActivityCapability;

  public AttackerUnsafeUserActivityCapabilityWithReverseReach attackerUnsafeUserActivityCapabilityWithReverseReach;

  public AttackerUnsafeUserActivityCapabilityWithoutReverseReach attackerUnsafeUserActivityCapabilityWithoutReverseReach;

  public SupplyChainAuditing supplyChainAuditing;

  public BypassSupplyChainAuditing bypassSupplyChainAuditing;

  public SupplyChainAuditingBypassed supplyChainAuditingBypassed;

  public AttemptFullAccessFromSupplyChainCompromise attemptFullAccessFromSupplyChainCompromise;

  public FullAccessFromSupplyChainCompromise fullAccessFromSupplyChainCompromise;

  public AttemptReadFromSoftProdVulnerability attemptReadFromSoftProdVulnerability;

  public AttemptModifyFromSoftProdVulnerability attemptModifyFromSoftProdVulnerability;

  public AttemptDenyFromSoftProdVulnerability attemptDenyFromSoftProdVulnerability;

  public SoftwareCheck softwareCheck;

  public SoftwareProductVulnerabilityLocalAccessAchieved softwareProductVulnerabilityLocalAccessAchieved;

  public SoftwareProductVulnerabilityNetworkAccessAchieved softwareProductVulnerabilityNetworkAccessAchieved;

  public SoftwareProductVulnerabilityPhysicalAccessAchieved softwareProductVulnerabilityPhysicalAccessAchieved;

  public SoftwareProductVulnerabilityLowPrivilegesAchieved softwareProductVulnerabilityLowPrivilegesAchieved;

  public SoftwareProductVulnerabilityHighPrivilegesAchieved softwareProductVulnerabilityHighPrivilegesAchieved;

  public SoftwareProductVulnerabilityUserInteractionAchieved softwareProductVulnerabilityUserInteractionAchieved;

  public AttemptSoftwareProductAbuse attemptSoftwareProductAbuse;

  public SoftwareProductAbuse softwareProductAbuse;

  public ReadFromSoftProdVulnerability readFromSoftProdVulnerability;

  public ModifyFromSoftProdVulnerability modifyFromSoftProdVulnerability;

  public DenyFromSoftProdVulnerability denyFromSoftProdVulnerability;

  public AttemptApplicationRespondConnectThroughData attemptApplicationRespondConnectThroughData;

  public SuccessfulApplicationRespondConnectThroughData successfulApplicationRespondConnectThroughData;

  public ApplicationRespondConnectThroughData applicationRespondConnectThroughData;

  public AttemptAuthorizedApplicationRespondConnectThroughData attemptAuthorizedApplicationRespondConnectThroughData;

  public SuccessfulAuthorizedApplicationRespondConnectThroughData successfulAuthorizedApplicationRespondConnectThroughData;

  public AuthorizedApplicationRespondConnectThroughData authorizedApplicationRespondConnectThroughData;

  public AttemptRead attemptRead;

  public SuccessfulRead successfulRead;

  public Read read;

  public SpecificAccessRead specificAccessRead;

  public AttemptModify attemptModify;

  public SuccessfulModify successfulModify;

  public Modify modify;

  public SpecificAccessModify specificAccessModify;

  public AttemptDeny attemptDeny;

  public SuccessfulDeny successfulDeny;

  public Deny deny;

  public SpecificAccessDelete specificAccessDelete;

  public DenyFromNetworkingAsset denyFromNetworkingAsset;

  public DenyFromLockout denyFromLockout;

  private Set<SoftwareVulnerability> _cacheallVulnerabilitiesApplication;

  private Set<ConnectionRule> _cacheingoingApplicationConnectionsApplication;

  private Set<ConnectionRule> _cacheoutgoingApplicationConnectionsApplication;

  private Set<Network> _cachereverseallowedApplicationConnectionsApplicationsNetwork;

  private Set<ConnectionRule> _cachereversesenderApplicationsConnectionRule;

  private Set<ConnectionRule> _cachereversereceiverApplicationsConnectionRule;

  private Set<ConnectionRule> _cachereverseallApplicationsConnectionRule;

  public Hardware hostHardware = null;

  public Set<Application> appExecutedApps = new HashSet<>();

  public Application hostApp = null;

  public Set<IDPS> protectorIDPSs = new HashSet<>();

  public SoftwareProduct appSoftProduct = null;

  public Set<Data> containedData = new HashSet<>();

  public Set<Data> sentData = new HashSet<>();

  public Set<Data> receivedData = new HashSet<>();

  public Set<Data> dataDependedUpon = new HashSet<>();

  public Set<Information> infoDependedUpon = new HashSet<>();

  public Set<IAMObject> executionPrivIAMs = new HashSet<>();

  public Set<IAMObject> highPrivAppIAMs = new HashSet<>();

  public Set<IAMObject> lowPrivAppIAMs = new HashSet<>();

  public Set<RoutingFirewall> managedRoutingFw = new HashSet<>();

  public Set<Network> networks = new HashSet<>();

  public Set<ConnectionRule> appConnections = new HashSet<>();

  public Set<ConnectionRule> ingoingAppConnections = new HashSet<>();

  public Set<ConnectionRule> outgoingAppConnections = new HashSet<>();

  public Set<SoftwareVulnerability> vulnerabilities = new HashSet<>();

  public Application(String name, boolean isNotPresentEnabled,
      boolean isSupplyChainAuditingEnabled) {
    super(name);
    assetClassName = "Application";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, isNotPresentEnabled);
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
    AttackStep.allAttackSteps.remove(networkConnectUninspected);
    networkConnectUninspected = new NetworkConnectUninspected(name);
    AttackStep.allAttackSteps.remove(networkConnectInspected);
    networkConnectInspected = new NetworkConnectInspected(name);
    AttackStep.allAttackSteps.remove(networkConnect);
    networkConnect = new NetworkConnect(name);
    AttackStep.allAttackSteps.remove(specificAccessNetworkConnect);
    specificAccessNetworkConnect = new SpecificAccessNetworkConnect(name);
    AttackStep.allAttackSteps.remove(accessNetworkAndConnections);
    accessNetworkAndConnections = new AccessNetworkAndConnections(name);
    AttackStep.allAttackSteps.remove(attemptNetworkConnectFromResponse);
    attemptNetworkConnectFromResponse = new AttemptNetworkConnectFromResponse(name);
    AttackStep.allAttackSteps.remove(networkConnectFromResponse);
    networkConnectFromResponse = new NetworkConnectFromResponse(name);
    AttackStep.allAttackSteps.remove(specificAccessFromLocalConnection);
    specificAccessFromLocalConnection = new SpecificAccessFromLocalConnection(name);
    AttackStep.allAttackSteps.remove(specificAccessFromNetworkConnection);
    specificAccessFromNetworkConnection = new SpecificAccessFromNetworkConnection(name);
    AttackStep.allAttackSteps.remove(specificAccess);
    specificAccess = new SpecificAccess(name);
    AttackStep.allAttackSteps.remove(bypassContainerization);
    bypassContainerization = new BypassContainerization(name);
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
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(successfulUnsafeUserActivity);
    successfulUnsafeUserActivity = new SuccessfulUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(attackerUnsafeUserActivityCapability);
    attackerUnsafeUserActivityCapability = new AttackerUnsafeUserActivityCapability(name);
    AttackStep.allAttackSteps.remove(attackerUnsafeUserActivityCapabilityWithReverseReach);
    attackerUnsafeUserActivityCapabilityWithReverseReach = new AttackerUnsafeUserActivityCapabilityWithReverseReach(name);
    AttackStep.allAttackSteps.remove(attackerUnsafeUserActivityCapabilityWithoutReverseReach);
    attackerUnsafeUserActivityCapabilityWithoutReverseReach = new AttackerUnsafeUserActivityCapabilityWithoutReverseReach(name);
    if (supplyChainAuditing != null) {
      AttackStep.allAttackSteps.remove(supplyChainAuditing.disable);
    }
    Defense.allDefenses.remove(supplyChainAuditing);
    supplyChainAuditing = new SupplyChainAuditing(name, isSupplyChainAuditingEnabled);
    AttackStep.allAttackSteps.remove(bypassSupplyChainAuditing);
    bypassSupplyChainAuditing = new BypassSupplyChainAuditing(name);
    AttackStep.allAttackSteps.remove(supplyChainAuditingBypassed);
    supplyChainAuditingBypassed = new SupplyChainAuditingBypassed(name);
    AttackStep.allAttackSteps.remove(attemptFullAccessFromSupplyChainCompromise);
    attemptFullAccessFromSupplyChainCompromise = new AttemptFullAccessFromSupplyChainCompromise(name);
    AttackStep.allAttackSteps.remove(fullAccessFromSupplyChainCompromise);
    fullAccessFromSupplyChainCompromise = new FullAccessFromSupplyChainCompromise(name);
    AttackStep.allAttackSteps.remove(attemptReadFromSoftProdVulnerability);
    attemptReadFromSoftProdVulnerability = new AttemptReadFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptModifyFromSoftProdVulnerability);
    attemptModifyFromSoftProdVulnerability = new AttemptModifyFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptDenyFromSoftProdVulnerability);
    attemptDenyFromSoftProdVulnerability = new AttemptDenyFromSoftProdVulnerability(name);
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
    AttackStep.allAttackSteps.remove(readFromSoftProdVulnerability);
    readFromSoftProdVulnerability = new ReadFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(modifyFromSoftProdVulnerability);
    modifyFromSoftProdVulnerability = new ModifyFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(denyFromSoftProdVulnerability);
    denyFromSoftProdVulnerability = new DenyFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnectThroughData);
    attemptApplicationRespondConnectThroughData = new AttemptApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(successfulApplicationRespondConnectThroughData);
    successfulApplicationRespondConnectThroughData = new SuccessfulApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(applicationRespondConnectThroughData);
    applicationRespondConnectThroughData = new ApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(attemptAuthorizedApplicationRespondConnectThroughData);
    attemptAuthorizedApplicationRespondConnectThroughData = new AttemptAuthorizedApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(successfulAuthorizedApplicationRespondConnectThroughData);
    successfulAuthorizedApplicationRespondConnectThroughData = new SuccessfulAuthorizedApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(authorizedApplicationRespondConnectThroughData);
    authorizedApplicationRespondConnectThroughData = new AuthorizedApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(attemptRead);
    attemptRead = new AttemptRead(name);
    AttackStep.allAttackSteps.remove(successfulRead);
    successfulRead = new SuccessfulRead(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(specificAccessRead);
    specificAccessRead = new SpecificAccessRead(name);
    AttackStep.allAttackSteps.remove(attemptModify);
    attemptModify = new AttemptModify(name);
    AttackStep.allAttackSteps.remove(successfulModify);
    successfulModify = new SuccessfulModify(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
    AttackStep.allAttackSteps.remove(specificAccessModify);
    specificAccessModify = new SpecificAccessModify(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(successfulDeny);
    successfulDeny = new SuccessfulDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(specificAccessDelete);
    specificAccessDelete = new SpecificAccessDelete(name);
    AttackStep.allAttackSteps.remove(denyFromNetworkingAsset);
    denyFromNetworkingAsset = new DenyFromNetworkingAsset(name);
    AttackStep.allAttackSteps.remove(denyFromLockout);
    denyFromLockout = new DenyFromLockout(name);
  }

  public Application(String name) {
    super(name);
    assetClassName = "Application";
    if (notPresent != null) {
      AttackStep.allAttackSteps.remove(notPresent.disable);
    }
    Defense.allDefenses.remove(notPresent);
    notPresent = new NotPresent(name, false);
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
    AttackStep.allAttackSteps.remove(networkConnectUninspected);
    networkConnectUninspected = new NetworkConnectUninspected(name);
    AttackStep.allAttackSteps.remove(networkConnectInspected);
    networkConnectInspected = new NetworkConnectInspected(name);
    AttackStep.allAttackSteps.remove(networkConnect);
    networkConnect = new NetworkConnect(name);
    AttackStep.allAttackSteps.remove(specificAccessNetworkConnect);
    specificAccessNetworkConnect = new SpecificAccessNetworkConnect(name);
    AttackStep.allAttackSteps.remove(accessNetworkAndConnections);
    accessNetworkAndConnections = new AccessNetworkAndConnections(name);
    AttackStep.allAttackSteps.remove(attemptNetworkConnectFromResponse);
    attemptNetworkConnectFromResponse = new AttemptNetworkConnectFromResponse(name);
    AttackStep.allAttackSteps.remove(networkConnectFromResponse);
    networkConnectFromResponse = new NetworkConnectFromResponse(name);
    AttackStep.allAttackSteps.remove(specificAccessFromLocalConnection);
    specificAccessFromLocalConnection = new SpecificAccessFromLocalConnection(name);
    AttackStep.allAttackSteps.remove(specificAccessFromNetworkConnection);
    specificAccessFromNetworkConnection = new SpecificAccessFromNetworkConnection(name);
    AttackStep.allAttackSteps.remove(specificAccess);
    specificAccess = new SpecificAccess(name);
    AttackStep.allAttackSteps.remove(bypassContainerization);
    bypassContainerization = new BypassContainerization(name);
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
    AttackStep.allAttackSteps.remove(attemptUnsafeUserActivity);
    attemptUnsafeUserActivity = new AttemptUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(successfulUnsafeUserActivity);
    successfulUnsafeUserActivity = new SuccessfulUnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(unsafeUserActivity);
    unsafeUserActivity = new UnsafeUserActivity(name);
    AttackStep.allAttackSteps.remove(attackerUnsafeUserActivityCapability);
    attackerUnsafeUserActivityCapability = new AttackerUnsafeUserActivityCapability(name);
    AttackStep.allAttackSteps.remove(attackerUnsafeUserActivityCapabilityWithReverseReach);
    attackerUnsafeUserActivityCapabilityWithReverseReach = new AttackerUnsafeUserActivityCapabilityWithReverseReach(name);
    AttackStep.allAttackSteps.remove(attackerUnsafeUserActivityCapabilityWithoutReverseReach);
    attackerUnsafeUserActivityCapabilityWithoutReverseReach = new AttackerUnsafeUserActivityCapabilityWithoutReverseReach(name);
    if (supplyChainAuditing != null) {
      AttackStep.allAttackSteps.remove(supplyChainAuditing.disable);
    }
    Defense.allDefenses.remove(supplyChainAuditing);
    supplyChainAuditing = new SupplyChainAuditing(name, false);
    AttackStep.allAttackSteps.remove(bypassSupplyChainAuditing);
    bypassSupplyChainAuditing = new BypassSupplyChainAuditing(name);
    AttackStep.allAttackSteps.remove(supplyChainAuditingBypassed);
    supplyChainAuditingBypassed = new SupplyChainAuditingBypassed(name);
    AttackStep.allAttackSteps.remove(attemptFullAccessFromSupplyChainCompromise);
    attemptFullAccessFromSupplyChainCompromise = new AttemptFullAccessFromSupplyChainCompromise(name);
    AttackStep.allAttackSteps.remove(fullAccessFromSupplyChainCompromise);
    fullAccessFromSupplyChainCompromise = new FullAccessFromSupplyChainCompromise(name);
    AttackStep.allAttackSteps.remove(attemptReadFromSoftProdVulnerability);
    attemptReadFromSoftProdVulnerability = new AttemptReadFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptModifyFromSoftProdVulnerability);
    attemptModifyFromSoftProdVulnerability = new AttemptModifyFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptDenyFromSoftProdVulnerability);
    attemptDenyFromSoftProdVulnerability = new AttemptDenyFromSoftProdVulnerability(name);
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
    AttackStep.allAttackSteps.remove(readFromSoftProdVulnerability);
    readFromSoftProdVulnerability = new ReadFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(modifyFromSoftProdVulnerability);
    modifyFromSoftProdVulnerability = new ModifyFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(denyFromSoftProdVulnerability);
    denyFromSoftProdVulnerability = new DenyFromSoftProdVulnerability(name);
    AttackStep.allAttackSteps.remove(attemptApplicationRespondConnectThroughData);
    attemptApplicationRespondConnectThroughData = new AttemptApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(successfulApplicationRespondConnectThroughData);
    successfulApplicationRespondConnectThroughData = new SuccessfulApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(applicationRespondConnectThroughData);
    applicationRespondConnectThroughData = new ApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(attemptAuthorizedApplicationRespondConnectThroughData);
    attemptAuthorizedApplicationRespondConnectThroughData = new AttemptAuthorizedApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(successfulAuthorizedApplicationRespondConnectThroughData);
    successfulAuthorizedApplicationRespondConnectThroughData = new SuccessfulAuthorizedApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(authorizedApplicationRespondConnectThroughData);
    authorizedApplicationRespondConnectThroughData = new AuthorizedApplicationRespondConnectThroughData(name);
    AttackStep.allAttackSteps.remove(attemptRead);
    attemptRead = new AttemptRead(name);
    AttackStep.allAttackSteps.remove(successfulRead);
    successfulRead = new SuccessfulRead(name);
    AttackStep.allAttackSteps.remove(read);
    read = new Read(name);
    AttackStep.allAttackSteps.remove(specificAccessRead);
    specificAccessRead = new SpecificAccessRead(name);
    AttackStep.allAttackSteps.remove(attemptModify);
    attemptModify = new AttemptModify(name);
    AttackStep.allAttackSteps.remove(successfulModify);
    successfulModify = new SuccessfulModify(name);
    AttackStep.allAttackSteps.remove(modify);
    modify = new Modify(name);
    AttackStep.allAttackSteps.remove(specificAccessModify);
    specificAccessModify = new SpecificAccessModify(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(successfulDeny);
    successfulDeny = new SuccessfulDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(specificAccessDelete);
    specificAccessDelete = new SpecificAccessDelete(name);
    AttackStep.allAttackSteps.remove(denyFromNetworkingAsset);
    denyFromNetworkingAsset = new DenyFromNetworkingAsset(name);
    AttackStep.allAttackSteps.remove(denyFromLockout);
    denyFromLockout = new DenyFromLockout(name);
  }

  public Application(boolean isNotPresentEnabled, boolean isSupplyChainAuditingEnabled) {
    this("Anonymous", isNotPresentEnabled, isSupplyChainAuditingEnabled);
  }

  public Application() {
    this("Anonymous");
  }

  protected Set<SoftwareVulnerability> _allVulnerabilitiesApplication() {
    if (_cacheallVulnerabilitiesApplication == null) {
      _cacheallVulnerabilitiesApplication = new HashSet<>();
      Set<SoftwareVulnerability> _1 = new HashSet<>();
      Set<SoftwareVulnerability> _2 = new HashSet<>();
      for (SoftwareVulnerability _3 : vulnerabilities) {
        _1.add(_3);
      }
      if (appSoftProduct != null) {
        for (SoftwareVulnerability _4 : appSoftProduct.softProductVulnerabilities) {
          _2.add(_4);
        }
      }
      _1.addAll(_2);
      for (SoftwareVulnerability _5 : _1) {
        _cacheallVulnerabilitiesApplication.add(_5);
      }
    }
    return _cacheallVulnerabilitiesApplication;
  }

  protected Set<ConnectionRule> _ingoingApplicationConnectionsApplication() {
    if (_cacheingoingApplicationConnectionsApplication == null) {
      _cacheingoingApplicationConnectionsApplication = new HashSet<>();
      Set<ConnectionRule> _6 = new HashSet<>();
      Set<ConnectionRule> _7 = new HashSet<>();
      for (ConnectionRule _8 : appConnections) {
        _6.add(_8);
      }
      for (ConnectionRule _9 : ingoingAppConnections) {
        _7.add(_9);
      }
      _6.addAll(_7);
      for (ConnectionRule _a : _6) {
        _cacheingoingApplicationConnectionsApplication.add(_a);
      }
    }
    return _cacheingoingApplicationConnectionsApplication;
  }

  protected Set<ConnectionRule> _outgoingApplicationConnectionsApplication() {
    if (_cacheoutgoingApplicationConnectionsApplication == null) {
      _cacheoutgoingApplicationConnectionsApplication = new HashSet<>();
      Set<ConnectionRule> _b = new HashSet<>();
      Set<ConnectionRule> _c = new HashSet<>();
      for (ConnectionRule _d : appConnections) {
        _b.add(_d);
      }
      for (ConnectionRule _e : outgoingAppConnections) {
        _c.add(_e);
      }
      _b.addAll(_c);
      for (ConnectionRule _f : _b) {
        _cacheoutgoingApplicationConnectionsApplication.add(_f);
      }
    }
    return _cacheoutgoingApplicationConnectionsApplication;
  }

  protected Set<Network> _reverseallowedApplicationConnectionsApplicationsNetwork() {
    if (_cachereverseallowedApplicationConnectionsApplicationsNetwork == null) {
      _cachereverseallowedApplicationConnectionsApplicationsNetwork = new HashSet<>();
      Set<Network> _10 = new HashSet<>();
      Set<Network> _11 = new HashSet<>();
      for (ConnectionRule _12 : appConnections) {
        for (var _13 : _12._reverseallNetConnectionsNetwork()) {
          _10.add(_13);
        }
      }
      for (Network _14 : networks) {
        _11.add(_14);
      }
      _10.addAll(_11);
      for (Network _15 : _10) {
        _cachereverseallowedApplicationConnectionsApplicationsNetwork.add(_15);
      }
    }
    return _cachereverseallowedApplicationConnectionsApplicationsNetwork;
  }

  protected Set<ConnectionRule> _reversesenderApplicationsConnectionRule() {
    if (_cachereversesenderApplicationsConnectionRule == null) {
      _cachereversesenderApplicationsConnectionRule = new HashSet<>();
      Set<ConnectionRule> _16 = new HashSet<>();
      Set<ConnectionRule> _17 = new HashSet<>();
      for (ConnectionRule _18 : outgoingAppConnections) {
        _16.add(_18);
      }
      for (ConnectionRule _19 : appConnections) {
        _17.add(_19);
      }
      _16.addAll(_17);
      for (ConnectionRule _1a : _16) {
        _cachereversesenderApplicationsConnectionRule.add(_1a);
      }
    }
    return _cachereversesenderApplicationsConnectionRule;
  }

  protected Set<ConnectionRule> _reversereceiverApplicationsConnectionRule() {
    if (_cachereversereceiverApplicationsConnectionRule == null) {
      _cachereversereceiverApplicationsConnectionRule = new HashSet<>();
      Set<ConnectionRule> _1b = new HashSet<>();
      Set<ConnectionRule> _1c = new HashSet<>();
      for (ConnectionRule _1d : ingoingAppConnections) {
        _1b.add(_1d);
      }
      for (ConnectionRule _1e : appConnections) {
        _1c.add(_1e);
      }
      _1b.addAll(_1c);
      for (ConnectionRule _1f : _1b) {
        _cachereversereceiverApplicationsConnectionRule.add(_1f);
      }
    }
    return _cachereversereceiverApplicationsConnectionRule;
  }

  protected Set<ConnectionRule> _reverseallApplicationsConnectionRule() {
    if (_cachereverseallApplicationsConnectionRule == null) {
      _cachereverseallApplicationsConnectionRule = new HashSet<>();
      Set<ConnectionRule> _20 = new HashSet<>();
      Set<ConnectionRule> _21 = new HashSet<>();
      for (ConnectionRule _22 : outgoingAppConnections) {
        _20.add(_22);
      }
      Set<ConnectionRule> _23 = new HashSet<>();
      Set<ConnectionRule> _24 = new HashSet<>();
      for (ConnectionRule _25 : ingoingAppConnections) {
        _23.add(_25);
      }
      for (ConnectionRule _26 : appConnections) {
        _24.add(_26);
      }
      _23.addAll(_24);
      for (ConnectionRule _27 : _23) {
        _21.add(_27);
      }
      _20.addAll(_21);
      for (ConnectionRule _28 : _20) {
        _cachereverseallApplicationsConnectionRule.add(_28);
      }
    }
    return _cachereverseallApplicationsConnectionRule;
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

  public void addDataDependedUpon(Data dataDependedUpon) {
    this.dataDependedUpon.add(dataDependedUpon);
    dataDependedUpon.dependentApps.add(this);
  }

  public void addInfoDependedUpon(Information infoDependedUpon) {
    this.infoDependedUpon.add(infoDependedUpon);
    infoDependedUpon.dependentApps.add(this);
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

  public void addManagedRoutingFw(RoutingFirewall managedRoutingFw) {
    this.managedRoutingFw.add(managedRoutingFw);
    managedRoutingFw.managerApp = this;
  }

  public void addNetworks(Network networks) {
    this.networks.add(networks);
    networks.applications.add(this);
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

  public void addVulnerabilities(SoftwareVulnerability vulnerabilities) {
    this.vulnerabilities.add(vulnerabilities);
    vulnerabilities.application = this;
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("hostHardware")) {
      return Hardware.class.getName();
    } else if (field.equals("appExecutedApps")) {
      return Application.class.getName();
    } else if (field.equals("hostApp")) {
      return Application.class.getName();
    } else if (field.equals("protectorIDPSs")) {
      return IDPS.class.getName();
    } else if (field.equals("appSoftProduct")) {
      return SoftwareProduct.class.getName();
    } else if (field.equals("containedData")) {
      return Data.class.getName();
    } else if (field.equals("sentData")) {
      return Data.class.getName();
    } else if (field.equals("receivedData")) {
      return Data.class.getName();
    } else if (field.equals("dataDependedUpon")) {
      return Data.class.getName();
    } else if (field.equals("infoDependedUpon")) {
      return Information.class.getName();
    } else if (field.equals("executionPrivIAMs")) {
      return IAMObject.class.getName();
    } else if (field.equals("highPrivAppIAMs")) {
      return IAMObject.class.getName();
    } else if (field.equals("lowPrivAppIAMs")) {
      return IAMObject.class.getName();
    } else if (field.equals("managedRoutingFw")) {
      return RoutingFirewall.class.getName();
    } else if (field.equals("networks")) {
      return Network.class.getName();
    } else if (field.equals("appConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("ingoingAppConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("outgoingAppConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("vulnerabilities")) {
      return SoftwareVulnerability.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("hostHardware")) {
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
    } else if (field.equals("containedData")) {
      assets.addAll(containedData);
    } else if (field.equals("sentData")) {
      assets.addAll(sentData);
    } else if (field.equals("receivedData")) {
      assets.addAll(receivedData);
    } else if (field.equals("dataDependedUpon")) {
      assets.addAll(dataDependedUpon);
    } else if (field.equals("infoDependedUpon")) {
      assets.addAll(infoDependedUpon);
    } else if (field.equals("executionPrivIAMs")) {
      assets.addAll(executionPrivIAMs);
    } else if (field.equals("highPrivAppIAMs")) {
      assets.addAll(highPrivAppIAMs);
    } else if (field.equals("lowPrivAppIAMs")) {
      assets.addAll(lowPrivAppIAMs);
    } else if (field.equals("managedRoutingFw")) {
      assets.addAll(managedRoutingFw);
    } else if (field.equals("networks")) {
      assets.addAll(networks);
    } else if (field.equals("appConnections")) {
      assets.addAll(appConnections);
    } else if (field.equals("ingoingAppConnections")) {
      assets.addAll(ingoingAppConnections);
    } else if (field.equals("outgoingAppConnections")) {
      assets.addAll(outgoingAppConnections);
    } else if (field.equals("vulnerabilities")) {
      assets.addAll(vulnerabilities);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
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
    assets.addAll(containedData);
    assets.addAll(sentData);
    assets.addAll(receivedData);
    assets.addAll(dataDependedUpon);
    assets.addAll(infoDependedUpon);
    assets.addAll(executionPrivIAMs);
    assets.addAll(highPrivAppIAMs);
    assets.addAll(lowPrivAppIAMs);
    assets.addAll(managedRoutingFw);
    assets.addAll(networks);
    assets.addAll(appConnections);
    assets.addAll(ingoingAppConnections);
    assets.addAll(outgoingAppConnections);
    assets.addAll(vulnerabilities);
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
          _cacheChildrenNotPresent.add(successfulUseVulnerability);
          _cacheChildrenNotPresent.add(successfulReverseReach);
          _cacheChildrenNotPresent.add(networkConnectFromResponse);
          _cacheChildrenNotPresent.add(specificAccessFromLocalConnection);
          _cacheChildrenNotPresent.add(specificAccessFromNetworkConnection);
          _cacheChildrenNotPresent.add(localAccess);
          _cacheChildrenNotPresent.add(networkAccess);
          _cacheChildrenNotPresent.add(successfulUnsafeUserActivity);
          _cacheChildrenNotPresent.add(fullAccessFromSupplyChainCompromise);
          _cacheChildrenNotPresent.add(readFromSoftProdVulnerability);
          _cacheChildrenNotPresent.add(modifyFromSoftProdVulnerability);
          _cacheChildrenNotPresent.add(denyFromSoftProdVulnerability);
          _cacheChildrenNotPresent.add(successfulApplicationRespondConnectThroughData);
          _cacheChildrenNotPresent.add(successfulAuthorizedApplicationRespondConnectThroughData);
          _cacheChildrenNotPresent.add(successfulRead);
          _cacheChildrenNotPresent.add(successfulModify);
          _cacheChildrenNotPresent.add(successfulDeny);
        }
        for (AttackStep attackStep : _cacheChildrenNotPresent) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Application.notPresent";
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
        for (IDPS _0 : protectorIDPSs) {
          _cacheChildrenAttemptUseVulnerability.add(_0.bypassEffectiveness);
        }
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
        _cacheParentAttemptUseVulnerability.add(networkConnectUninspected);
        _cacheParentAttemptUseVulnerability.add(specificAccess);
        for (Application _1 : appExecutedApps) {
          _cacheParentAttemptUseVulnerability.add(_1.bypassContainerization);
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
        _cacheParentSuccessfulUseVulnerability.add(notPresent.disable);
        _cacheParentSuccessfulUseVulnerability.add(attemptUseVulnerability);
        for (IDPS _0 : protectorIDPSs) {
          _cacheParentSuccessfulUseVulnerability.add(_0.effectivenessBypassed);
        }
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
        _cacheChildrenUseVulnerability.add(readFromSoftProdVulnerability);
        _cacheChildrenUseVulnerability.add(modifyFromSoftProdVulnerability);
        _cacheChildrenUseVulnerability.add(denyFromSoftProdVulnerability);
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
        for (Network _0 : networks) {
          _cacheParentAttemptReverseReach.add(_0.reverseReach);
        }
        for (var _1 : _reversesenderApplicationsConnectionRule()) {
          _cacheParentAttemptReverseReach.add(_1.reverseReach);
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
        _cacheParentSuccessfulReverseReach.add(notPresent.disable);
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
        for (var _1 : _ingoingApplicationConnectionsApplication()) {
          _cacheChildrenReverseReach.add(_1.attemptReverseReach);
        }
        for (Application _2 : appExecutedApps) {
          _cacheChildrenReverseReach.add(_2.attemptReverseReach);
        }
        _cacheChildrenReverseReach.add(attackerUnsafeUserActivityCapabilityWithReverseReach);
        for (Data _3 : containedData) {
          _cacheChildrenReverseReach.add(_3.attemptReverseReach);
        }
        for (Data _4 : sentData) {
          _cacheChildrenReverseReach.add(_4.attemptReverseReach);
        }
        for (Data _5 : receivedData) {
          _cacheChildrenReverseReach.add(_5.attemptReverseReach);
        }
        _cacheChildrenReverseReach.add(networkConnectFromResponse);
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
        _cacheParentLocalConnect.add(unsafeUserActivity);
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

  public class NetworkConnectUninspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkConnectUninspected;

    private Set<AttackStep> _cacheParentNetworkConnectUninspected;

    public NetworkConnectUninspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkConnectUninspected == null) {
        _cacheChildrenNetworkConnectUninspected = new HashSet<>();
        _cacheChildrenNetworkConnectUninspected.add(attemptUseVulnerability);
        for (var _0 : _allVulnerabilitiesApplication()) {
          _cacheChildrenNetworkConnectUninspected.add(_0.networkAccessAchieved);
        }
        _cacheChildrenNetworkConnectUninspected.add(softwareProductVulnerabilityNetworkAccessAchieved);
        _cacheChildrenNetworkConnectUninspected.add(networkConnect);
        _cacheChildrenNetworkConnectUninspected.add(specificAccessNetworkConnect);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkConnectUninspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkConnectUninspected == null) {
        _cacheParentNetworkConnectUninspected = new HashSet<>();
        _cacheParentNetworkConnectUninspected.add(networkConnectFromResponse);
        _cacheParentNetworkConnectUninspected.add(unsafeUserActivity);
        for (Network _1 : networks) {
          _cacheParentNetworkConnectUninspected.add(_1.accessUninspected);
        }
        for (ConnectionRule _2 : appConnections) {
          if (_2.routingFirewalls != null) {
            _cacheParentNetworkConnectUninspected.add(_2.routingFirewalls.fullAccess);
          }
        }
        for (var _3 : _reversereceiverApplicationsConnectionRule()) {
          _cacheParentNetworkConnectUninspected.add(_3.connectToApplicationsUninspected);
        }
      }
      for (AttackStep attackStep : _cacheParentNetworkConnectUninspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkConnectUninspected");
    }
  }

  public class NetworkConnectInspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkConnectInspected;

    private Set<AttackStep> _cacheParentNetworkConnectInspected;

    public NetworkConnectInspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkConnectInspected == null) {
        _cacheChildrenNetworkConnectInspected = new HashSet<>();
        _cacheChildrenNetworkConnectInspected.add(networkConnect);
        _cacheChildrenNetworkConnectInspected.add(specificAccessNetworkConnect);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkConnectInspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkConnectInspected == null) {
        _cacheParentNetworkConnectInspected = new HashSet<>();
        for (Network _0 : networks) {
          _cacheParentNetworkConnectInspected.add(_0.accessInspected);
        }
        for (var _1 : _reversereceiverApplicationsConnectionRule()) {
          _cacheParentNetworkConnectInspected.add(_1.connectToApplicationsUninspected);
        }
        for (var _2 : _reversereceiverApplicationsConnectionRule()) {
          _cacheParentNetworkConnectInspected.add(_2.connectToApplicationsInspected);
        }
      }
      for (AttackStep attackStep : _cacheParentNetworkConnectInspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkConnectInspected");
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
        _cacheChildrenNetworkConnect.add(networkAccess);
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
        _cacheParentNetworkConnect.add(networkConnectUninspected);
        _cacheParentNetworkConnect.add(networkConnectInspected);
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

  public class SpecificAccessNetworkConnect extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSpecificAccessNetworkConnect;

    private Set<AttackStep> _cacheParentSpecificAccessNetworkConnect;

    public SpecificAccessNetworkConnect(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessNetworkConnect == null) {
        _cacheChildrenSpecificAccessNetworkConnect = new HashSet<>();
        _cacheChildrenSpecificAccessNetworkConnect.add(specificAccessFromNetworkConnection);
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessNetworkConnect) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessNetworkConnect == null) {
        _cacheParentSpecificAccessNetworkConnect = new HashSet<>();
        _cacheParentSpecificAccessNetworkConnect.add(networkConnectUninspected);
        _cacheParentSpecificAccessNetworkConnect.add(networkConnectInspected);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessNetworkConnect) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessNetworkConnect");
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
          _cacheChildrenAccessNetworkAndConnections.add(_0.accessUninspected);
        }
        for (Network _1 : networks) {
          _cacheChildrenAccessNetworkAndConnections.add(_1.accessInspected);
        }
        for (var _2 : _outgoingApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_2.attemptConnectToApplicationsUninspected);
        }
        for (var _3 : _outgoingApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_3.attemptConnectToApplicationsInspected);
        }
        for (var _4 : _outgoingApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_4.attemptAccessNetworksUninspected);
        }
        for (var _5 : _outgoingApplicationConnectionsApplication()) {
          _cacheChildrenAccessNetworkAndConnections.add(_5.attemptAccessNetworksInspected);
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

  public class AttemptNetworkConnectFromResponse extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptNetworkConnectFromResponse;

    private Set<AttackStep> _cacheParentAttemptNetworkConnectFromResponse;

    public AttemptNetworkConnectFromResponse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptNetworkConnectFromResponse == null) {
        _cacheChildrenAttemptNetworkConnectFromResponse = new HashSet<>();
        _cacheChildrenAttemptNetworkConnectFromResponse.add(networkConnectFromResponse);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptNetworkConnectFromResponse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptNetworkConnectFromResponse == null) {
        _cacheParentAttemptNetworkConnectFromResponse = new HashSet<>();
        for (Data _0 : sentData) {
          _cacheParentAttemptNetworkConnectFromResponse.add(_0.applicationRespondConnect);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptNetworkConnectFromResponse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptNetworkConnectFromResponse");
    }
  }

  public class NetworkConnectFromResponse extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenNetworkConnectFromResponse;

    private Set<AttackStep> _cacheParentNetworkConnectFromResponse;

    public NetworkConnectFromResponse(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkConnectFromResponse == null) {
        _cacheChildrenNetworkConnectFromResponse = new HashSet<>();
        _cacheChildrenNetworkConnectFromResponse.add(networkConnectUninspected);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkConnectFromResponse) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkConnectFromResponse == null) {
        _cacheParentNetworkConnectFromResponse = new HashSet<>();
        _cacheParentNetworkConnectFromResponse.add(notPresent.disable);
        _cacheParentNetworkConnectFromResponse.add(reverseReach);
        _cacheParentNetworkConnectFromResponse.add(attemptNetworkConnectFromResponse);
      }
      for (AttackStep attackStep : _cacheParentNetworkConnectFromResponse) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.networkConnectFromResponse");
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
        _cacheParentSpecificAccessFromLocalConnection.add(notPresent.disable);
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
        _cacheParentSpecificAccessFromNetworkConnection.add(notPresent.disable);
        _cacheParentSpecificAccessFromNetworkConnection.add(specificAccessNetworkConnect);
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
        _cacheChildrenSpecificAccess.add(specificAccessRead);
        _cacheChildrenSpecificAccess.add(specificAccessModify);
        _cacheChildrenSpecificAccess.add(specificAccessDelete);
        _cacheChildrenSpecificAccess.add(bypassContainerization);
        _cacheChildrenSpecificAccess.add(attemptUseVulnerability);
        _cacheChildrenSpecificAccess.add(attemptAuthorizedApplicationRespondConnectThroughData);
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

  public class BypassContainerization extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassContainerization;

    private Set<AttackStep> _cacheParentBypassContainerization;

    public BypassContainerization(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassContainerization == null) {
        _cacheChildrenBypassContainerization = new HashSet<>();
        if (hostApp != null) {
          _cacheChildrenBypassContainerization.add(hostApp.attemptUseVulnerability);
        }
      }
      for (AttackStep attackStep : _cacheChildrenBypassContainerization) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassContainerization == null) {
        _cacheParentBypassContainerization = new HashSet<>();
        _cacheParentBypassContainerization.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheParentBypassContainerization) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.bypassContainerization");
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
        _cacheParentLocalAccess.add(notPresent.disable);
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
        _cacheParentNetworkAccess.add(notPresent.disable);
        _cacheParentNetworkAccess.add(networkConnect);
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
        for (IAMObject _0 : executionPrivIAMs) {
          _cacheChildrenFullAccess.add(_0.attemptAssume);
        }
        _cacheChildrenFullAccess.add(attemptApplicationRespondConnectThroughData);
        _cacheChildrenFullAccess.add(accessNetworkAndConnections);
        if (hostApp != null) {
          _cacheChildrenFullAccess.add(hostApp.localConnect);
        }
        for (RoutingFirewall _1 : managedRoutingFw) {
          _cacheChildrenFullAccess.add(_1.attemptModify);
        }
        if (hostHardware != null) {
          _cacheChildrenFullAccess.add(hostHardware.attemptSpreadWormThroughRemovableMedia);
        }
        if (hostHardware != null) {
          _cacheChildrenFullAccess.add(hostHardware.attemptUseVulnerabilityFromSoftwareFullAccess);
        }
        _cacheChildrenFullAccess.add(specificAccess);
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
        _cacheParentFullAccess.add(fullAccessFromSupplyChainCompromise);
        _cacheParentFullAccess.add(modify);
        for (Information _2 : infoDependedUpon) {
          _cacheParentFullAccess.add(_2.write);
        }
        for (Data _3 : dataDependedUpon) {
          _cacheParentFullAccess.add(_3.write);
        }
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
        _cacheChildrenAttemptUnsafeUserActivity.add(attackerUnsafeUserActivityCapabilityWithReverseReach);
        _cacheChildrenAttemptUnsafeUserActivity.add(attackerUnsafeUserActivityCapabilityWithoutReverseReach);
        for (IDPS _0 : protectorIDPSs) {
          _cacheChildrenAttemptUnsafeUserActivity.add(_0.bypassEffectiveness);
        }
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
        for (IAMObject _1 : executionPrivIAMs) {
          if (_1 instanceof Identity) {
            _cacheParentAttemptUnsafeUserActivity.add(((com.coevolution.corelang.Identity) _1).unsafeUserActivity);
          }
        }
        for (IAMObject _2 : highPrivAppIAMs) {
          if (_2 instanceof Identity) {
            _cacheParentAttemptUnsafeUserActivity.add(((com.coevolution.corelang.Identity) _2).unsafeUserActivity);
          }
        }
        for (IAMObject _3 : lowPrivAppIAMs) {
          if (_3 instanceof Identity) {
            _cacheParentAttemptUnsafeUserActivity.add(((com.coevolution.corelang.Identity) _3).unsafeUserActivity);
          }
        }
        for (IAMObject _4 : executionPrivIAMs) {
          if (_4 instanceof Privileges) {
            _cacheParentAttemptUnsafeUserActivity.add(((com.coevolution.corelang.Privileges) _4).unsafeUserActivity);
          }
        }
        for (IAMObject _5 : highPrivAppIAMs) {
          if (_5 instanceof Privileges) {
            _cacheParentAttemptUnsafeUserActivity.add(((com.coevolution.corelang.Privileges) _5).unsafeUserActivity);
          }
        }
        for (IAMObject _6 : lowPrivAppIAMs) {
          if (_6 instanceof Privileges) {
            _cacheParentAttemptUnsafeUserActivity.add(((com.coevolution.corelang.Privileges) _6).unsafeUserActivity);
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
        _cacheParentSuccessfulUnsafeUserActivity.add(notPresent.disable);
        _cacheParentSuccessfulUnsafeUserActivity.add(attemptUnsafeUserActivity);
        _cacheParentSuccessfulUnsafeUserActivity.add(attackerUnsafeUserActivityCapability);
        for (IDPS _0 : protectorIDPSs) {
          _cacheParentSuccessfulUnsafeUserActivity.add(_0.effectivenessBypassed);
        }
      }
      for (AttackStep attackStep : _cacheParentSuccessfulUnsafeUserActivity) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.successfulUnsafeUserActivity");
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
        _cacheChildrenUnsafeUserActivity.add(localConnect);
        _cacheChildrenUnsafeUserActivity.add(networkConnectUninspected);
        for (var _0 : _allVulnerabilitiesApplication()) {
          _cacheChildrenUnsafeUserActivity.add(_0.userInteractionAchieved);
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
      return ttcHashMap.get("Application.unsafeUserActivity");
    }
  }

  public class AttackerUnsafeUserActivityCapability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttackerUnsafeUserActivityCapability;

    private Set<AttackStep> _cacheParentAttackerUnsafeUserActivityCapability;

    public AttackerUnsafeUserActivityCapability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttackerUnsafeUserActivityCapability == null) {
        _cacheChildrenAttackerUnsafeUserActivityCapability = new HashSet<>();
        _cacheChildrenAttackerUnsafeUserActivityCapability.add(successfulUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheChildrenAttackerUnsafeUserActivityCapability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttackerUnsafeUserActivityCapability == null) {
        _cacheParentAttackerUnsafeUserActivityCapability = new HashSet<>();
        _cacheParentAttackerUnsafeUserActivityCapability.add(attackerUnsafeUserActivityCapabilityWithReverseReach);
        _cacheParentAttackerUnsafeUserActivityCapability.add(attackerUnsafeUserActivityCapabilityWithoutReverseReach);
      }
      for (AttackStep attackStep : _cacheParentAttackerUnsafeUserActivityCapability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attackerUnsafeUserActivityCapability");
    }
  }

  public class AttackerUnsafeUserActivityCapabilityWithReverseReach extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenAttackerUnsafeUserActivityCapabilityWithReverseReach;

    private Set<AttackStep> _cacheParentAttackerUnsafeUserActivityCapabilityWithReverseReach;

    public AttackerUnsafeUserActivityCapabilityWithReverseReach(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttackerUnsafeUserActivityCapabilityWithReverseReach == null) {
        _cacheChildrenAttackerUnsafeUserActivityCapabilityWithReverseReach = new HashSet<>();
        _cacheChildrenAttackerUnsafeUserActivityCapabilityWithReverseReach.add(attackerUnsafeUserActivityCapability);
      }
      for (AttackStep attackStep : _cacheChildrenAttackerUnsafeUserActivityCapabilityWithReverseReach) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttackerUnsafeUserActivityCapabilityWithReverseReach == null) {
        _cacheParentAttackerUnsafeUserActivityCapabilityWithReverseReach = new HashSet<>();
        _cacheParentAttackerUnsafeUserActivityCapabilityWithReverseReach.add(reverseReach);
        _cacheParentAttackerUnsafeUserActivityCapabilityWithReverseReach.add(attemptUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheParentAttackerUnsafeUserActivityCapabilityWithReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attackerUnsafeUserActivityCapabilityWithReverseReach");
    }
  }

  public class AttackerUnsafeUserActivityCapabilityWithoutReverseReach extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttackerUnsafeUserActivityCapabilityWithoutReverseReach;

    private Set<AttackStep> _cacheParentAttackerUnsafeUserActivityCapabilityWithoutReverseReach;

    public AttackerUnsafeUserActivityCapabilityWithoutReverseReach(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttackerUnsafeUserActivityCapabilityWithoutReverseReach == null) {
        _cacheChildrenAttackerUnsafeUserActivityCapabilityWithoutReverseReach = new HashSet<>();
        _cacheChildrenAttackerUnsafeUserActivityCapabilityWithoutReverseReach.add(attackerUnsafeUserActivityCapability);
      }
      for (AttackStep attackStep : _cacheChildrenAttackerUnsafeUserActivityCapabilityWithoutReverseReach) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttackerUnsafeUserActivityCapabilityWithoutReverseReach == null) {
        _cacheParentAttackerUnsafeUserActivityCapabilityWithoutReverseReach = new HashSet<>();
        _cacheParentAttackerUnsafeUserActivityCapabilityWithoutReverseReach.add(attemptUnsafeUserActivity);
      }
      for (AttackStep attackStep : _cacheParentAttackerUnsafeUserActivityCapabilityWithoutReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attackerUnsafeUserActivityCapabilityWithoutReverseReach");
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
        return "Application.supplyChainAuditing";
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
        _cacheParentBypassSupplyChainAuditing.add(attemptFullAccessFromSupplyChainCompromise);
      }
      for (AttackStep attackStep : _cacheParentBypassSupplyChainAuditing) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.bypassSupplyChainAuditing");
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
        _cacheChildrenSupplyChainAuditingBypassed.add(fullAccessFromSupplyChainCompromise);
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
      return ttcHashMap.get("Application.supplyChainAuditingBypassed");
    }
  }

  public class AttemptFullAccessFromSupplyChainCompromise extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptFullAccessFromSupplyChainCompromise;

    private Set<AttackStep> _cacheParentAttemptFullAccessFromSupplyChainCompromise;

    public AttemptFullAccessFromSupplyChainCompromise(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptFullAccessFromSupplyChainCompromise == null) {
        _cacheChildrenAttemptFullAccessFromSupplyChainCompromise = new HashSet<>();
        _cacheChildrenAttemptFullAccessFromSupplyChainCompromise.add(fullAccessFromSupplyChainCompromise);
        _cacheChildrenAttemptFullAccessFromSupplyChainCompromise.add(bypassSupplyChainAuditing);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptFullAccessFromSupplyChainCompromise) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptFullAccessFromSupplyChainCompromise == null) {
        _cacheParentAttemptFullAccessFromSupplyChainCompromise = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptFullAccessFromSupplyChainCompromise.add(appSoftProduct.compromiseApplications);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptFullAccessFromSupplyChainCompromise) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptFullAccessFromSupplyChainCompromise");
    }
  }

  public class FullAccessFromSupplyChainCompromise extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenFullAccessFromSupplyChainCompromise;

    private Set<AttackStep> _cacheParentFullAccessFromSupplyChainCompromise;

    public FullAccessFromSupplyChainCompromise(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenFullAccessFromSupplyChainCompromise == null) {
        _cacheChildrenFullAccessFromSupplyChainCompromise = new HashSet<>();
        _cacheChildrenFullAccessFromSupplyChainCompromise.add(fullAccess);
      }
      for (AttackStep attackStep : _cacheChildrenFullAccessFromSupplyChainCompromise) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentFullAccessFromSupplyChainCompromise == null) {
        _cacheParentFullAccessFromSupplyChainCompromise = new HashSet<>();
        _cacheParentFullAccessFromSupplyChainCompromise.add(notPresent.disable);
        _cacheParentFullAccessFromSupplyChainCompromise.add(supplyChainAuditingBypassed);
        _cacheParentFullAccessFromSupplyChainCompromise.add(attemptFullAccessFromSupplyChainCompromise);
      }
      for (AttackStep attackStep : _cacheParentFullAccessFromSupplyChainCompromise) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.fullAccessFromSupplyChainCompromise");
    }
  }

  public class AttemptReadFromSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptReadFromSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptReadFromSoftProdVulnerability;

    public AttemptReadFromSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptReadFromSoftProdVulnerability == null) {
        _cacheChildrenAttemptReadFromSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptReadFromSoftProdVulnerability.add(readFromSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptReadFromSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptReadFromSoftProdVulnerability == null) {
        _cacheParentAttemptReadFromSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptReadFromSoftProdVulnerability.add(appSoftProduct.readApplications);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptReadFromSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptReadFromSoftProdVulnerability");
    }
  }

  public class AttemptModifyFromSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptModifyFromSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptModifyFromSoftProdVulnerability;

    public AttemptModifyFromSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptModifyFromSoftProdVulnerability == null) {
        _cacheChildrenAttemptModifyFromSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptModifyFromSoftProdVulnerability.add(modifyFromSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptModifyFromSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptModifyFromSoftProdVulnerability == null) {
        _cacheParentAttemptModifyFromSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptModifyFromSoftProdVulnerability.add(appSoftProduct.modifyApplications);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptModifyFromSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptModifyFromSoftProdVulnerability");
    }
  }

  public class AttemptDenyFromSoftProdVulnerability extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptDenyFromSoftProdVulnerability;

    private Set<AttackStep> _cacheParentAttemptDenyFromSoftProdVulnerability;

    public AttemptDenyFromSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptDenyFromSoftProdVulnerability == null) {
        _cacheChildrenAttemptDenyFromSoftProdVulnerability = new HashSet<>();
        _cacheChildrenAttemptDenyFromSoftProdVulnerability.add(denyFromSoftProdVulnerability);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptDenyFromSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptDenyFromSoftProdVulnerability == null) {
        _cacheParentAttemptDenyFromSoftProdVulnerability = new HashSet<>();
        if (appSoftProduct != null) {
          _cacheParentAttemptDenyFromSoftProdVulnerability.add(appSoftProduct.denyApplications);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDenyFromSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptDenyFromSoftProdVulnerability");
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
          _cacheChildrenSoftwareCheck.add(readFromSoftProdVulnerability);
          _cacheChildrenSoftwareCheck.add(modifyFromSoftProdVulnerability);
          _cacheChildrenSoftwareCheck.add(denyFromSoftProdVulnerability);
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
        _cacheParentSoftwareProductVulnerabilityLocalAccessAchieved.add(localConnect);
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityLocalAccessAchieved.add(_1.localAccessRequired.disable);
          }
        }
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
        _cacheParentSoftwareProductVulnerabilityNetworkAccessAchieved.add(networkConnectUninspected);
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityNetworkAccessAchieved.add(_1.networkAccessRequired.disable);
          }
        }
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
        _cacheParentSoftwareProductVulnerabilityPhysicalAccessAchieved.add(physicalAccessAchieved);
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityPhysicalAccessAchieved.add(_1.physicalAccessRequired.disable);
          }
        }
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
        _cacheParentSoftwareProductVulnerabilityLowPrivilegesAchieved.add(specificAccessAuthenticate);
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityLowPrivilegesAchieved.add(_1.lowPrivilegesRequired.disable);
          }
        }
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
        _cacheParentSoftwareProductVulnerabilityHighPrivilegesAchieved.add(authenticate);
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _1 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityHighPrivilegesAchieved.add(_1.highPrivilegesRequired.disable);
          }
        }
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
        if (appSoftProduct != null) {
          for (SoftwareVulnerability _2 : appSoftProduct.softProductVulnerabilities) {
            _cacheParentSoftwareProductVulnerabilityUserInteractionAchieved.add(_2.inherentUserInteraction);
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
        _cacheChildrenSoftwareProductAbuse.add(readFromSoftProdVulnerability);
        _cacheChildrenSoftwareProductAbuse.add(modifyFromSoftProdVulnerability);
        _cacheChildrenSoftwareProductAbuse.add(denyFromSoftProdVulnerability);
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

  public class ReadFromSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenReadFromSoftProdVulnerability;

    private Set<AttackStep> _cacheParentReadFromSoftProdVulnerability;

    public ReadFromSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenReadFromSoftProdVulnerability == null) {
        _cacheChildrenReadFromSoftProdVulnerability = new HashSet<>();
        _cacheChildrenReadFromSoftProdVulnerability.add(attemptRead);
      }
      for (AttackStep attackStep : _cacheChildrenReadFromSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentReadFromSoftProdVulnerability == null) {
        _cacheParentReadFromSoftProdVulnerability = new HashSet<>();
        _cacheParentReadFromSoftProdVulnerability.add(notPresent.disable);
        _cacheParentReadFromSoftProdVulnerability.add(useVulnerability);
        _cacheParentReadFromSoftProdVulnerability.add(attemptReadFromSoftProdVulnerability);
        _cacheParentReadFromSoftProdVulnerability.add(softwareCheck.disable);
        _cacheParentReadFromSoftProdVulnerability.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheParentReadFromSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.readFromSoftProdVulnerability");
    }
  }

  public class ModifyFromSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenModifyFromSoftProdVulnerability;

    private Set<AttackStep> _cacheParentModifyFromSoftProdVulnerability;

    public ModifyFromSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenModifyFromSoftProdVulnerability == null) {
        _cacheChildrenModifyFromSoftProdVulnerability = new HashSet<>();
        _cacheChildrenModifyFromSoftProdVulnerability.add(attemptModify);
      }
      for (AttackStep attackStep : _cacheChildrenModifyFromSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentModifyFromSoftProdVulnerability == null) {
        _cacheParentModifyFromSoftProdVulnerability = new HashSet<>();
        _cacheParentModifyFromSoftProdVulnerability.add(notPresent.disable);
        _cacheParentModifyFromSoftProdVulnerability.add(useVulnerability);
        _cacheParentModifyFromSoftProdVulnerability.add(attemptModifyFromSoftProdVulnerability);
        _cacheParentModifyFromSoftProdVulnerability.add(softwareCheck.disable);
        _cacheParentModifyFromSoftProdVulnerability.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheParentModifyFromSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.modifyFromSoftProdVulnerability");
    }
  }

  public class DenyFromSoftProdVulnerability extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDenyFromSoftProdVulnerability;

    private Set<AttackStep> _cacheParentDenyFromSoftProdVulnerability;

    public DenyFromSoftProdVulnerability(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenyFromSoftProdVulnerability == null) {
        _cacheChildrenDenyFromSoftProdVulnerability = new HashSet<>();
        _cacheChildrenDenyFromSoftProdVulnerability.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheChildrenDenyFromSoftProdVulnerability) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenyFromSoftProdVulnerability == null) {
        _cacheParentDenyFromSoftProdVulnerability = new HashSet<>();
        _cacheParentDenyFromSoftProdVulnerability.add(notPresent.disable);
        _cacheParentDenyFromSoftProdVulnerability.add(useVulnerability);
        _cacheParentDenyFromSoftProdVulnerability.add(attemptDenyFromSoftProdVulnerability);
        _cacheParentDenyFromSoftProdVulnerability.add(softwareCheck.disable);
        _cacheParentDenyFromSoftProdVulnerability.add(softwareProductAbuse);
      }
      for (AttackStep attackStep : _cacheParentDenyFromSoftProdVulnerability) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.denyFromSoftProdVulnerability");
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
        _cacheParentSuccessfulApplicationRespondConnectThroughData.add(notPresent.disable);
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

  public class AttemptAuthorizedApplicationRespondConnectThroughData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAuthorizedApplicationRespondConnectThroughData;

    private Set<AttackStep> _cacheParentAttemptAuthorizedApplicationRespondConnectThroughData;

    public AttemptAuthorizedApplicationRespondConnectThroughData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAuthorizedApplicationRespondConnectThroughData == null) {
        _cacheChildrenAttemptAuthorizedApplicationRespondConnectThroughData = new HashSet<>();
        _cacheChildrenAttemptAuthorizedApplicationRespondConnectThroughData.add(successfulAuthorizedApplicationRespondConnectThroughData);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAuthorizedApplicationRespondConnectThroughData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAuthorizedApplicationRespondConnectThroughData == null) {
        _cacheParentAttemptAuthorizedApplicationRespondConnectThroughData = new HashSet<>();
        _cacheParentAttemptAuthorizedApplicationRespondConnectThroughData.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptAuthorizedApplicationRespondConnectThroughData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.attemptAuthorizedApplicationRespondConnectThroughData");
    }
  }

  public class SuccessfulAuthorizedApplicationRespondConnectThroughData extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulAuthorizedApplicationRespondConnectThroughData;

    private Set<AttackStep> _cacheParentSuccessfulAuthorizedApplicationRespondConnectThroughData;

    public SuccessfulAuthorizedApplicationRespondConnectThroughData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAuthorizedApplicationRespondConnectThroughData == null) {
        _cacheChildrenSuccessfulAuthorizedApplicationRespondConnectThroughData = new HashSet<>();
        _cacheChildrenSuccessfulAuthorizedApplicationRespondConnectThroughData.add(authorizedApplicationRespondConnectThroughData);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAuthorizedApplicationRespondConnectThroughData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulAuthorizedApplicationRespondConnectThroughData == null) {
        _cacheParentSuccessfulAuthorizedApplicationRespondConnectThroughData = new HashSet<>();
        _cacheParentSuccessfulAuthorizedApplicationRespondConnectThroughData.add(notPresent.disable);
        _cacheParentSuccessfulAuthorizedApplicationRespondConnectThroughData.add(attemptAuthorizedApplicationRespondConnectThroughData);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAuthorizedApplicationRespondConnectThroughData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.successfulAuthorizedApplicationRespondConnectThroughData");
    }
  }

  public class AuthorizedApplicationRespondConnectThroughData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAuthorizedApplicationRespondConnectThroughData;

    private Set<AttackStep> _cacheParentAuthorizedApplicationRespondConnectThroughData;

    public AuthorizedApplicationRespondConnectThroughData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAuthorizedApplicationRespondConnectThroughData == null) {
        _cacheChildrenAuthorizedApplicationRespondConnectThroughData = new HashSet<>();
        for (Data _0 : receivedData) {
          _cacheChildrenAuthorizedApplicationRespondConnectThroughData.add(_0.authorizedApplicationRespondConnectFromApplication);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAuthorizedApplicationRespondConnectThroughData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAuthorizedApplicationRespondConnectThroughData == null) {
        _cacheParentAuthorizedApplicationRespondConnectThroughData = new HashSet<>();
        _cacheParentAuthorizedApplicationRespondConnectThroughData.add(successfulAuthorizedApplicationRespondConnectThroughData);
      }
      for (AttackStep attackStep : _cacheParentAuthorizedApplicationRespondConnectThroughData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.authorizedApplicationRespondConnectThroughData");
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
        _cacheParentAttemptRead.add(readFromSoftProdVulnerability);
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
        _cacheParentSuccessfulRead.add(notPresent.disable);
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
        for (Data _2 : sentData) {
          _cacheChildrenRead.add(_2.attemptRead);
        }
        for (Data _3 : receivedData) {
          _cacheChildrenRead.add(_3.attemptRead);
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
        _cacheParentRead.add(successfulRead);
        for (SoftwareVulnerability _4 : vulnerabilities) {
          _cacheParentRead.add(_4.read);
        }
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

  public class SpecificAccessRead extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSpecificAccessRead;

    private Set<AttackStep> _cacheParentSpecificAccessRead;

    public SpecificAccessRead(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessRead == null) {
        _cacheChildrenSpecificAccessRead = new HashSet<>();
        for (Data _0 : containedData) {
          _cacheChildrenSpecificAccessRead.add(_0.authorizedReadFromApplication);
        }
        for (Data _1 : sentData) {
          _cacheChildrenSpecificAccessRead.add(_1.authorizedReadFromApplication);
        }
        for (Data _2 : receivedData) {
          _cacheChildrenSpecificAccessRead.add(_2.authorizedReadFromApplication);
        }
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessRead) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessRead == null) {
        _cacheParentSpecificAccessRead = new HashSet<>();
        _cacheParentSpecificAccessRead.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessRead) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessRead");
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
        if (Application.this instanceof RoutingFirewall) {
          if (((com.coevolution.corelang.RoutingFirewall) Application.this).managerApp != null) {
            _cacheParentAttemptModify.add(((com.coevolution.corelang.RoutingFirewall) Application.this).managerApp.fullAccess);
          }
        }
        _cacheParentAttemptModify.add(modifyFromSoftProdVulnerability);
        if (hostApp != null) {
          _cacheParentAttemptModify.add(hostApp.modify);
        }
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
        _cacheParentSuccessfulModify.add(notPresent.disable);
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
        _cacheChildrenModify.add(fullAccess);
        for (Data _0 : containedData) {
          _cacheChildrenModify.add(_0.attemptWrite);
        }
        for (Application _1 : appExecutedApps) {
          _cacheChildrenModify.add(_1.attemptModify);
        }
        for (Data _2 : sentData) {
          _cacheChildrenModify.add(_2.attemptWrite);
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
        _cacheParentModify.add(successfulModify);
        for (SoftwareVulnerability _3 : vulnerabilities) {
          _cacheParentModify.add(_3.modify);
        }
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

  public class SpecificAccessModify extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSpecificAccessModify;

    private Set<AttackStep> _cacheParentSpecificAccessModify;

    public SpecificAccessModify(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessModify == null) {
        _cacheChildrenSpecificAccessModify = new HashSet<>();
        for (Data _0 : containedData) {
          _cacheChildrenSpecificAccessModify.add(_0.authorizedWriteFromApplication);
        }
        for (Data _1 : sentData) {
          _cacheChildrenSpecificAccessModify.add(_1.authorizedWriteFromApplication);
        }
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessModify) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessModify == null) {
        _cacheParentSpecificAccessModify = new HashSet<>();
        _cacheParentSpecificAccessModify.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessModify) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessModify");
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
        _cacheParentAttemptDeny.add(denyFromSoftProdVulnerability);
        if (hostApp != null) {
          _cacheParentAttemptDeny.add(hostApp.deny);
        }
        _cacheParentAttemptDeny.add(denyFromNetworkingAsset);
        _cacheParentAttemptDeny.add(denyFromLockout);
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
        _cacheParentSuccessfulDeny.add(notPresent.disable);
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
        for (Application _1 : appExecutedApps) {
          _cacheChildrenDeny.add(_1.attemptDeny);
        }
        for (Data _2 : sentData) {
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
        _cacheParentDeny.add(successfulDeny);
        for (Information _3 : infoDependedUpon) {
          _cacheParentDeny.add(_3.deny);
        }
        for (Data _4 : dataDependedUpon) {
          _cacheParentDeny.add(_4.deny);
        }
        for (SoftwareVulnerability _5 : vulnerabilities) {
          _cacheParentDeny.add(_5.deny);
        }
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

  public class SpecificAccessDelete extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSpecificAccessDelete;

    private Set<AttackStep> _cacheParentSpecificAccessDelete;

    public SpecificAccessDelete(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSpecificAccessDelete == null) {
        _cacheChildrenSpecificAccessDelete = new HashSet<>();
        for (Data _0 : containedData) {
          _cacheChildrenSpecificAccessDelete.add(_0.authorizedDeleteFromApplication);
        }
        for (Data _1 : sentData) {
          _cacheChildrenSpecificAccessDelete.add(_1.authorizedDeleteFromApplication);
        }
      }
      for (AttackStep attackStep : _cacheChildrenSpecificAccessDelete) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSpecificAccessDelete == null) {
        _cacheParentSpecificAccessDelete = new HashSet<>();
        _cacheParentSpecificAccessDelete.add(specificAccess);
      }
      for (AttackStep attackStep : _cacheParentSpecificAccessDelete) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.specificAccessDelete");
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
          _cacheParentDenyFromNetworkingAsset.add(_0.deny);
        }
        for (var _1 : _reverseallApplicationsConnectionRule()) {
          _cacheParentDenyFromNetworkingAsset.add(_1.deny);
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
        for (IAMObject _0 : executionPrivIAMs) {
          _cacheParentDenyFromLockout.add(_0.lockout);
        }
      }
      for (AttackStep attackStep : _cacheParentDenyFromLockout) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Application.denyFromLockout");
    }
  }
}
