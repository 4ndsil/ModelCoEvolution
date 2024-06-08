package com.coevolution.corelang_0_5_2;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Network extends Asset {
  public PhysicalAccess physicalAccess;

  public NetworkAccessControl networkAccessControl;

  public BypassAccessControl bypassAccessControl;

  public AttemptAccess attemptAccess;

  public Access access;

  public SuccessfulAccess successfulAccess;

  public AttemptReverseReach attemptReverseReach;

  public ReverseReach reverseReach;

  public NetworkForwarding networkForwarding;

  public DenialOfService denialOfService;

  public AccessNetworkData accessNetworkData;

  public EavesdropDefense eavesdropDefense;

  public ManInTheMiddleDefense manInTheMiddleDefense;

  public Eavesdrop eavesdrop;

  public BypassEavesdropProtection bypassEavesdropProtection;

  public SuccessfulEavesdrop successfulEavesdrop;

  public ManInTheMiddle manInTheMiddle;

  public BypassMitMProtection bypassMitMProtection;

  public SuccessfulManInTheMiddle successfulManInTheMiddle;

  public EavesdropAfterPhysicalAccess eavesdropAfterPhysicalAccess;

  private Set<ConnectionRule> _cacheallowedApplicationConnectionsNetwork;

  private Set<ConnectionRule> _cacheallowedNetworkConnectionsNetwork;

  private Set<ConnectionRule> _cacheallNetConnectionsNetwork;

  private Set<Application> _cacheallNetApplicationsNetwork;

  private Set<Application> _cacheallowedApplicationConnectionsApplicationsNetwork;

  public Set<PhysicalZone> physicalZones = new HashSet<>();

  public Set<Application> applications = new HashSet<>();

  public Set<Application> clientApplications = new HashSet<>();

  public Set<ConnectionRule> netConnections = new HashSet<>();

  public Set<ConnectionRule> ingoingNetConnections = new HashSet<>();

  public Set<ConnectionRule> outgoingNetConnections = new HashSet<>();

  public Set<ConnectionRule> diodeIngoingNetConnections = new HashSet<>();

  public Set<Data> transitData = new HashSet<>();

  public Network(String name, boolean isNetworkAccessControlEnabled,
      boolean isEavesdropDefenseEnabled, boolean isManInTheMiddleDefenseEnabled) {
    super(name);
    assetClassName = "Network";
    AttackStep.allAttackSteps.remove(physicalAccess);
    physicalAccess = new PhysicalAccess(name);
    if (networkAccessControl != null) {
      AttackStep.allAttackSteps.remove(networkAccessControl.disable);
    }
    Defense.allDefenses.remove(networkAccessControl);
    networkAccessControl = new NetworkAccessControl(name, isNetworkAccessControlEnabled);
    AttackStep.allAttackSteps.remove(bypassAccessControl);
    bypassAccessControl = new BypassAccessControl(name);
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(access);
    access = new Access(name);
    AttackStep.allAttackSteps.remove(successfulAccess);
    successfulAccess = new SuccessfulAccess(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(networkForwarding);
    networkForwarding = new NetworkForwarding(name);
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(accessNetworkData);
    accessNetworkData = new AccessNetworkData(name);
    if (eavesdropDefense != null) {
      AttackStep.allAttackSteps.remove(eavesdropDefense.disable);
    }
    Defense.allDefenses.remove(eavesdropDefense);
    eavesdropDefense = new EavesdropDefense(name, isEavesdropDefenseEnabled);
    if (manInTheMiddleDefense != null) {
      AttackStep.allAttackSteps.remove(manInTheMiddleDefense.disable);
    }
    Defense.allDefenses.remove(manInTheMiddleDefense);
    manInTheMiddleDefense = new ManInTheMiddleDefense(name, isManInTheMiddleDefenseEnabled);
    AttackStep.allAttackSteps.remove(eavesdrop);
    eavesdrop = new Eavesdrop(name);
    AttackStep.allAttackSteps.remove(bypassEavesdropProtection);
    bypassEavesdropProtection = new BypassEavesdropProtection(name);
    AttackStep.allAttackSteps.remove(successfulEavesdrop);
    successfulEavesdrop = new SuccessfulEavesdrop(name);
    AttackStep.allAttackSteps.remove(manInTheMiddle);
    manInTheMiddle = new ManInTheMiddle(name);
    AttackStep.allAttackSteps.remove(bypassMitMProtection);
    bypassMitMProtection = new BypassMitMProtection(name);
    AttackStep.allAttackSteps.remove(successfulManInTheMiddle);
    successfulManInTheMiddle = new SuccessfulManInTheMiddle(name);
    AttackStep.allAttackSteps.remove(eavesdropAfterPhysicalAccess);
    eavesdropAfterPhysicalAccess = new EavesdropAfterPhysicalAccess(name);
  }

  public Network(String name) {
    super(name);
    assetClassName = "Network";
    AttackStep.allAttackSteps.remove(physicalAccess);
    physicalAccess = new PhysicalAccess(name);
    if (networkAccessControl != null) {
      AttackStep.allAttackSteps.remove(networkAccessControl.disable);
    }
    Defense.allDefenses.remove(networkAccessControl);
    networkAccessControl = new NetworkAccessControl(name, false);
    AttackStep.allAttackSteps.remove(bypassAccessControl);
    bypassAccessControl = new BypassAccessControl(name);
    AttackStep.allAttackSteps.remove(attemptAccess);
    attemptAccess = new AttemptAccess(name);
    AttackStep.allAttackSteps.remove(access);
    access = new Access(name);
    AttackStep.allAttackSteps.remove(successfulAccess);
    successfulAccess = new SuccessfulAccess(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(networkForwarding);
    networkForwarding = new NetworkForwarding(name);
    AttackStep.allAttackSteps.remove(denialOfService);
    denialOfService = new DenialOfService(name);
    AttackStep.allAttackSteps.remove(accessNetworkData);
    accessNetworkData = new AccessNetworkData(name);
    if (eavesdropDefense != null) {
      AttackStep.allAttackSteps.remove(eavesdropDefense.disable);
    }
    Defense.allDefenses.remove(eavesdropDefense);
    eavesdropDefense = new EavesdropDefense(name, false);
    if (manInTheMiddleDefense != null) {
      AttackStep.allAttackSteps.remove(manInTheMiddleDefense.disable);
    }
    Defense.allDefenses.remove(manInTheMiddleDefense);
    manInTheMiddleDefense = new ManInTheMiddleDefense(name, false);
    AttackStep.allAttackSteps.remove(eavesdrop);
    eavesdrop = new Eavesdrop(name);
    AttackStep.allAttackSteps.remove(bypassEavesdropProtection);
    bypassEavesdropProtection = new BypassEavesdropProtection(name);
    AttackStep.allAttackSteps.remove(successfulEavesdrop);
    successfulEavesdrop = new SuccessfulEavesdrop(name);
    AttackStep.allAttackSteps.remove(manInTheMiddle);
    manInTheMiddle = new ManInTheMiddle(name);
    AttackStep.allAttackSteps.remove(bypassMitMProtection);
    bypassMitMProtection = new BypassMitMProtection(name);
    AttackStep.allAttackSteps.remove(successfulManInTheMiddle);
    successfulManInTheMiddle = new SuccessfulManInTheMiddle(name);
    AttackStep.allAttackSteps.remove(eavesdropAfterPhysicalAccess);
    eavesdropAfterPhysicalAccess = new EavesdropAfterPhysicalAccess(name);
  }

  public Network(boolean isNetworkAccessControlEnabled, boolean isEavesdropDefenseEnabled,
      boolean isManInTheMiddleDefenseEnabled) {
    this("Anonymous", isNetworkAccessControlEnabled, isEavesdropDefenseEnabled, isManInTheMiddleDefenseEnabled);
  }

  public Network() {
    this("Anonymous");
  }

  protected Set<ConnectionRule> _allowedApplicationConnectionsNetwork() {
    if (_cacheallowedApplicationConnectionsNetwork == null) {
      _cacheallowedApplicationConnectionsNetwork = new HashSet<>();
      Set<ConnectionRule> _0 = new HashSet<>();
      Set<ConnectionRule> _1 = new HashSet<>();
      for (ConnectionRule _2 : netConnections) {
        _0.add(_2);
      }
      for (ConnectionRule _3 : outgoingNetConnections) {
        _1.add(_3);
      }
      _0.addAll(_1);
      for (ConnectionRule _4 : _0) {
        _cacheallowedApplicationConnectionsNetwork.add(_4);
      }
    }
    return _cacheallowedApplicationConnectionsNetwork;
  }

  protected Set<ConnectionRule> _allowedNetworkConnectionsNetwork() {
    if (_cacheallowedNetworkConnectionsNetwork == null) {
      _cacheallowedNetworkConnectionsNetwork = new HashSet<>();
      Set<ConnectionRule> _5 = new HashSet<>();
      Set<ConnectionRule> _6 = new HashSet<>();
      for (ConnectionRule _7 : netConnections) {
        _5.add(_7);
      }
      for (ConnectionRule _8 : outgoingNetConnections) {
        _6.add(_8);
      }
      _5.addAll(_6);
      for (ConnectionRule _9 : _5) {
        _cacheallowedNetworkConnectionsNetwork.add(_9);
      }
    }
    return _cacheallowedNetworkConnectionsNetwork;
  }

  protected Set<ConnectionRule> _allNetConnectionsNetwork() {
    if (_cacheallNetConnectionsNetwork == null) {
      _cacheallNetConnectionsNetwork = new HashSet<>();
      Set<ConnectionRule> _a = new HashSet<>();
      Set<ConnectionRule> _b = new HashSet<>();
      Set<ConnectionRule> _c = new HashSet<>();
      Set<ConnectionRule> _d = new HashSet<>();
      Set<ConnectionRule> _e = new HashSet<>();
      Set<ConnectionRule> _f = new HashSet<>();
      for (ConnectionRule _10 : netConnections) {
        _e.add(_10);
      }
      for (ConnectionRule _11 : ingoingNetConnections) {
        _f.add(_11);
      }
      _e.addAll(_f);
      for (ConnectionRule _12 : _e) {
        _c.add(_12);
      }
      for (ConnectionRule _13 : outgoingNetConnections) {
        _d.add(_13);
      }
      _c.addAll(_d);
      for (ConnectionRule _14 : _c) {
        _a.add(_14);
      }
      for (ConnectionRule _15 : diodeIngoingNetConnections) {
        _b.add(_15);
      }
      _a.addAll(_b);
      for (ConnectionRule _16 : _a) {
        _cacheallNetConnectionsNetwork.add(_16);
      }
    }
    return _cacheallNetConnectionsNetwork;
  }

  protected Set<Application> _allNetApplicationsNetwork() {
    if (_cacheallNetApplicationsNetwork == null) {
      _cacheallNetApplicationsNetwork = new HashSet<>();
      Set<Application> _17 = new HashSet<>();
      Set<Application> _18 = new HashSet<>();
      for (Application _19 : clientApplications) {
        _17.add(_19);
      }
      for (Application _1a : applications) {
        _18.add(_1a);
      }
      _17.addAll(_18);
      for (Application _1b : _17) {
        _cacheallNetApplicationsNetwork.add(_1b);
      }
    }
    return _cacheallNetApplicationsNetwork;
  }

  protected Set<Application> _allowedApplicationConnectionsApplicationsNetwork() {
    if (_cacheallowedApplicationConnectionsApplicationsNetwork == null) {
      _cacheallowedApplicationConnectionsApplicationsNetwork = new HashSet<>();
      Set<Application> _1c = new HashSet<>();
      Set<Application> _1d = new HashSet<>();
      for (var _1e : _allNetApplicationsNetwork()) {
        _1c.add(_1e);
      }
      for (var _1f : _allNetConnectionsNetwork()) {
        for (Application _20 : _1f.applications) {
          _1d.add(_20);
        }
      }
      _1c.addAll(_1d);
      for (Application _21 : _1c) {
        _cacheallowedApplicationConnectionsApplicationsNetwork.add(_21);
      }
    }
    return _cacheallowedApplicationConnectionsApplicationsNetwork;
  }

  public void addPhysicalZones(PhysicalZone physicalZones) {
    this.physicalZones.add(physicalZones);
    physicalZones.networks.add(this);
  }

  public void addApplications(Application applications) {
    this.applications.add(applications);
    applications.networks.add(this);
  }

  public void addClientApplications(Application clientApplications) {
    this.clientApplications.add(clientApplications);
    clientApplications.clientAccessNetworks.add(this);
  }

  public void addNetConnections(ConnectionRule netConnections) {
    this.netConnections.add(netConnections);
    netConnections.networks.add(this);
  }

  public void addIngoingNetConnections(ConnectionRule ingoingNetConnections) {
    this.ingoingNetConnections.add(ingoingNetConnections);
    ingoingNetConnections.inNetworks.add(this);
  }

  public void addOutgoingNetConnections(ConnectionRule outgoingNetConnections) {
    this.outgoingNetConnections.add(outgoingNetConnections);
    outgoingNetConnections.outNetworks.add(this);
  }

  public void addDiodeIngoingNetConnections(ConnectionRule diodeIngoingNetConnections) {
    this.diodeIngoingNetConnections.add(diodeIngoingNetConnections);
    diodeIngoingNetConnections.diodeInNetworks.add(this);
  }

  public void addTransitData(Data transitData) {
    this.transitData.add(transitData);
    transitData.transitNetwork.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("physicalZones")) {
      return PhysicalZone.class.getName();
    } else if (field.equals("applications")) {
      return Application.class.getName();
    } else if (field.equals("clientApplications")) {
      return Application.class.getName();
    } else if (field.equals("netConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("ingoingNetConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("outgoingNetConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("diodeIngoingNetConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("transitData")) {
      return Data.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("physicalZones")) {
      assets.addAll(physicalZones);
    } else if (field.equals("applications")) {
      assets.addAll(applications);
    } else if (field.equals("clientApplications")) {
      assets.addAll(clientApplications);
    } else if (field.equals("netConnections")) {
      assets.addAll(netConnections);
    } else if (field.equals("ingoingNetConnections")) {
      assets.addAll(ingoingNetConnections);
    } else if (field.equals("outgoingNetConnections")) {
      assets.addAll(outgoingNetConnections);
    } else if (field.equals("diodeIngoingNetConnections")) {
      assets.addAll(diodeIngoingNetConnections);
    } else if (field.equals("transitData")) {
      assets.addAll(transitData);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(physicalZones);
    assets.addAll(applications);
    assets.addAll(clientApplications);
    assets.addAll(netConnections);
    assets.addAll(ingoingNetConnections);
    assets.addAll(outgoingNetConnections);
    assets.addAll(diodeIngoingNetConnections);
    assets.addAll(transitData);
    return assets;
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
        _cacheChildrenPhysicalAccess.add(denialOfService);
        _cacheChildrenPhysicalAccess.add(eavesdropAfterPhysicalAccess);
        _cacheChildrenPhysicalAccess.add(attemptAccess);
        _cacheChildrenPhysicalAccess.add(bypassAccessControl);
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
        for (PhysicalZone _0 : physicalZones) {
          _cacheParentPhysicalAccess.add(_0.gainPhysicalAccess);
        }
      }
      for (AttackStep attackStep : _cacheParentPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.physicalAccess");
    }
  }

  public class NetworkAccessControl extends Defense {
    public NetworkAccessControl(String name) {
      this(name, false);
    }

    public NetworkAccessControl(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenNetworkAccessControl;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenNetworkAccessControl == null) {
          _cacheChildrenNetworkAccessControl = new HashSet<>();
          _cacheChildrenNetworkAccessControl.add(eavesdropAfterPhysicalAccess);
          _cacheChildrenNetworkAccessControl.add(attemptAccess);
        }
        for (AttackStep attackStep : _cacheChildrenNetworkAccessControl) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Network.networkAccessControl";
      }
    }
  }

  public class BypassAccessControl extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassAccessControl;

    private Set<AttackStep> _cacheParentBypassAccessControl;

    public BypassAccessControl(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassAccessControl == null) {
        _cacheChildrenBypassAccessControl = new HashSet<>();
        _cacheChildrenBypassAccessControl.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheChildrenBypassAccessControl) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassAccessControl == null) {
        _cacheParentBypassAccessControl = new HashSet<>();
        _cacheParentBypassAccessControl.add(physicalAccess);
      }
      for (AttackStep attackStep : _cacheParentBypassAccessControl) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassAccessControl");
    }
  }

  public class AttemptAccess extends AttackStepMax {
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
        _cacheParentAttemptAccess.add(physicalAccess);
        _cacheParentAttemptAccess.add(networkAccessControl.disable);
      }
      for (AttackStep attackStep : _cacheParentAttemptAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.attemptAccess");
    }
  }

  public class Access extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccess;

    private Set<AttackStep> _cacheParentAccess;

    public Access(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccess == null) {
        _cacheChildrenAccess = new HashSet<>();
        _cacheChildrenAccess.add(successfulAccess);
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
        for (Application _0 : applications) {
          _cacheParentAccess.add(_0.accessNetworkAndConnections);
        }
        for (Application _1 : clientApplications) {
          _cacheParentAccess.add(_1.accessNetworkAndConnections);
        }
        _cacheParentAccess.add(attemptAccess);
        Set<RoutingFirewall> _2 = new HashSet<>();
        Set<RoutingFirewall> _3 = new HashSet<>();
        for (ConnectionRule _4 : diodeIngoingNetConnections) {
          if (_4.routingFirewalls != null) {
            _2.add(_4.routingFirewalls);
          }
        }
        Set<RoutingFirewall> _5 = new HashSet<>();
        Set<RoutingFirewall> _6 = new HashSet<>();
        for (ConnectionRule _7 : ingoingNetConnections) {
          if (_7.routingFirewalls != null) {
            _5.add(_7.routingFirewalls);
          }
        }
        Set<RoutingFirewall> _8 = new HashSet<>();
        Set<RoutingFirewall> _9 = new HashSet<>();
        for (ConnectionRule _a : outgoingNetConnections) {
          if (_a.routingFirewalls != null) {
            _8.add(_a.routingFirewalls);
          }
        }
        for (ConnectionRule _b : netConnections) {
          if (_b.routingFirewalls != null) {
            _9.add(_b.routingFirewalls);
          }
        }
        _8.addAll(_9);
        for (RoutingFirewall _c : _8) {
          _6.add(_c);
        }
        _5.addAll(_6);
        for (RoutingFirewall _d : _5) {
          _3.add(_d);
        }
        _2.addAll(_3);
        for (RoutingFirewall _e : _2) {
          _cacheParentAccess.add(_e.fullAccess);
        }
        Set<ConnectionRule> _f = new HashSet<>();
        Set<ConnectionRule> _10 = new HashSet<>();
        for (ConnectionRule _11 : diodeIngoingNetConnections) {
          _f.add(_11);
        }
        Set<ConnectionRule> _12 = new HashSet<>();
        Set<ConnectionRule> _13 = new HashSet<>();
        for (ConnectionRule _14 : ingoingNetConnections) {
          _12.add(_14);
        }
        for (ConnectionRule _15 : netConnections) {
          _13.add(_15);
        }
        _12.addAll(_13);
        for (ConnectionRule _16 : _12) {
          _10.add(_16);
        }
        _f.addAll(_10);
        for (ConnectionRule _17 : _f) {
          _cacheParentAccess.add(_17.accessNetworks);
        }
      }
      for (AttackStep attackStep : _cacheParentAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.access");
    }
  }

  public class SuccessfulAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSuccessfulAccess;

    private Set<AttackStep> _cacheParentSuccessfulAccess;

    public SuccessfulAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAccess == null) {
        _cacheChildrenSuccessfulAccess = new HashSet<>();
        for (var _0 : _allowedApplicationConnectionsNetwork()) {
          _cacheChildrenSuccessfulAccess.add(_0.attemptConnectToApplications);
        }
        for (Application _1 : applications) {
          _cacheChildrenSuccessfulAccess.add(_1.networkConnect);
        }
        for (Application _2 : clientApplications) {
          _cacheChildrenSuccessfulAccess.add(_2.attemptNetworkConnectViaResponse);
        }
        _cacheChildrenSuccessfulAccess.add(accessNetworkData);
        _cacheChildrenSuccessfulAccess.add(networkForwarding);
        _cacheChildrenSuccessfulAccess.add(denialOfService);
        _cacheChildrenSuccessfulAccess.add(attemptReverseReach);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulAccess == null) {
        _cacheParentSuccessfulAccess = new HashSet<>();
        _cacheParentSuccessfulAccess.add(bypassAccessControl);
        _cacheParentSuccessfulAccess.add(access);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.successfulAccess");
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
        for (Application _0 : applications) {
          _cacheParentAttemptReverseReach.add(_0.reverseReach);
        }
        for (Application _1 : clientApplications) {
          _cacheParentAttemptReverseReach.add(_1.reverseReach);
        }
        _cacheParentAttemptReverseReach.add(successfulAccess);
        Set<ConnectionRule> _2 = new HashSet<>();
        Set<ConnectionRule> _3 = new HashSet<>();
        for (ConnectionRule _4 : outgoingNetConnections) {
          _2.add(_4);
        }
        for (ConnectionRule _5 : netConnections) {
          _3.add(_5);
        }
        _2.addAll(_3);
        for (ConnectionRule _6 : _2) {
          _cacheParentAttemptReverseReach.add(_6.reverseReach);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.attemptReverseReach");
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
        Set<ConnectionRule> _0 = new HashSet<>();
        Set<ConnectionRule> _1 = new HashSet<>();
        Set<ConnectionRule> _2 = new HashSet<>();
        Set<ConnectionRule> _3 = new HashSet<>();
        for (ConnectionRule _4 : netConnections) {
          _2.add(_4);
        }
        for (ConnectionRule _5 : ingoingNetConnections) {
          _3.add(_5);
        }
        _2.addAll(_3);
        for (ConnectionRule _6 : _2) {
          _0.add(_6);
        }
        for (ConnectionRule _7 : diodeIngoingNetConnections) {
          _1.add(_7);
        }
        _0.addAll(_1);
        for (ConnectionRule _8 : _0) {
          _cacheChildrenReverseReach.add(_8.attemptReverseReach);
        }
        for (Application _9 : clientApplications) {
          _cacheChildrenReverseReach.add(_9.attemptReverseReach);
        }
        for (Application _a : applications) {
          _cacheChildrenReverseReach.add(_a.attemptReverseReach);
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
      return ttcHashMap.get("Network.reverseReach");
    }
  }

  public class NetworkForwarding extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkForwarding;

    private Set<AttackStep> _cacheParentNetworkForwarding;

    public NetworkForwarding(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkForwarding == null) {
        _cacheChildrenNetworkForwarding = new HashSet<>();
        for (var _0 : _allowedNetworkConnectionsNetwork()) {
          _cacheChildrenNetworkForwarding.add(_0.attemptAccessNetworks);
        }
        for (var _1 : _allowedNetworkConnectionsNetwork()) {
          _cacheChildrenNetworkForwarding.add(_1.attemptConnectToApplications);
        }
      }
      for (AttackStep attackStep : _cacheChildrenNetworkForwarding) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkForwarding == null) {
        _cacheParentNetworkForwarding = new HashSet<>();
        _cacheParentNetworkForwarding.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheParentNetworkForwarding) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.networkForwarding");
    }
  }

  public class DenialOfService extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenDenialOfService;

    private Set<AttackStep> _cacheParentDenialOfService;

    public DenialOfService(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDenialOfService == null) {
        _cacheChildrenDenialOfService = new HashSet<>();
        for (var _0 : _allNetConnectionsNetwork()) {
          _cacheChildrenDenialOfService.add(_0.attemptDenialOfService);
        }
        for (var _1 : _allowedApplicationConnectionsApplicationsNetwork()) {
          _cacheChildrenDenialOfService.add(_1.denyFromNetworkingAsset);
        }
      }
      for (AttackStep attackStep : _cacheChildrenDenialOfService) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentDenialOfService == null) {
        _cacheParentDenialOfService = new HashSet<>();
        _cacheParentDenialOfService.add(physicalAccess);
        _cacheParentDenialOfService.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheParentDenialOfService) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.denialOfService");
    }
  }

  public class AccessNetworkData extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessNetworkData;

    private Set<AttackStep> _cacheParentAccessNetworkData;

    public AccessNetworkData(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessNetworkData == null) {
        _cacheChildrenAccessNetworkData = new HashSet<>();
        _cacheChildrenAccessNetworkData.add(eavesdrop);
        _cacheChildrenAccessNetworkData.add(bypassEavesdropProtection);
        _cacheChildrenAccessNetworkData.add(manInTheMiddle);
        _cacheChildrenAccessNetworkData.add(bypassMitMProtection);
      }
      for (AttackStep attackStep : _cacheChildrenAccessNetworkData) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessNetworkData == null) {
        _cacheParentAccessNetworkData = new HashSet<>();
        _cacheParentAccessNetworkData.add(successfulAccess);
      }
      for (AttackStep attackStep : _cacheParentAccessNetworkData) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.accessNetworkData");
    }
  }

  public class EavesdropDefense extends Defense {
    public EavesdropDefense(String name) {
      this(name, false);
    }

    public EavesdropDefense(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenEavesdropDefense;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenEavesdropDefense == null) {
          _cacheChildrenEavesdropDefense = new HashSet<>();
          _cacheChildrenEavesdropDefense.add(eavesdrop);
          _cacheChildrenEavesdropDefense.add(eavesdropAfterPhysicalAccess);
        }
        for (AttackStep attackStep : _cacheChildrenEavesdropDefense) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Network.eavesdropDefense";
      }
    }
  }

  public class ManInTheMiddleDefense extends Defense {
    public ManInTheMiddleDefense(String name) {
      this(name, false);
    }

    public ManInTheMiddleDefense(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenManInTheMiddleDefense;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenManInTheMiddleDefense == null) {
          _cacheChildrenManInTheMiddleDefense = new HashSet<>();
          _cacheChildrenManInTheMiddleDefense.add(manInTheMiddle);
        }
        for (AttackStep attackStep : _cacheChildrenManInTheMiddleDefense) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Network.manInTheMiddleDefense";
      }
    }
  }

  public class Eavesdrop extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenEavesdrop;

    private Set<AttackStep> _cacheParentEavesdrop;

    public Eavesdrop(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenEavesdrop == null) {
        _cacheChildrenEavesdrop = new HashSet<>();
        _cacheChildrenEavesdrop.add(successfulEavesdrop);
      }
      for (AttackStep attackStep : _cacheChildrenEavesdrop) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentEavesdrop == null) {
        _cacheParentEavesdrop = new HashSet<>();
        _cacheParentEavesdrop.add(accessNetworkData);
        _cacheParentEavesdrop.add(eavesdropDefense.disable);
      }
      for (AttackStep attackStep : _cacheParentEavesdrop) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.eavesdrop");
    }
  }

  public class BypassEavesdropProtection extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassEavesdropProtection;

    private Set<AttackStep> _cacheParentBypassEavesdropProtection;

    public BypassEavesdropProtection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassEavesdropProtection == null) {
        _cacheChildrenBypassEavesdropProtection = new HashSet<>();
        _cacheChildrenBypassEavesdropProtection.add(successfulEavesdrop);
      }
      for (AttackStep attackStep : _cacheChildrenBypassEavesdropProtection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassEavesdropProtection == null) {
        _cacheParentBypassEavesdropProtection = new HashSet<>();
        _cacheParentBypassEavesdropProtection.add(accessNetworkData);
      }
      for (AttackStep attackStep : _cacheParentBypassEavesdropProtection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassEavesdropProtection");
    }
  }

  public class SuccessfulEavesdrop extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSuccessfulEavesdrop;

    private Set<AttackStep> _cacheParentSuccessfulEavesdrop;

    public SuccessfulEavesdrop(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulEavesdrop == null) {
        _cacheChildrenSuccessfulEavesdrop = new HashSet<>();
        for (Data _0 : transitData) {
          _cacheChildrenSuccessfulEavesdrop.add(_0.attemptRead);
        }
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulEavesdrop) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulEavesdrop == null) {
        _cacheParentSuccessfulEavesdrop = new HashSet<>();
        _cacheParentSuccessfulEavesdrop.add(eavesdrop);
        _cacheParentSuccessfulEavesdrop.add(bypassEavesdropProtection);
        _cacheParentSuccessfulEavesdrop.add(eavesdropAfterPhysicalAccess);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulEavesdrop) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.successfulEavesdrop");
    }
  }

  public class ManInTheMiddle extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenManInTheMiddle;

    private Set<AttackStep> _cacheParentManInTheMiddle;

    public ManInTheMiddle(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenManInTheMiddle == null) {
        _cacheChildrenManInTheMiddle = new HashSet<>();
        _cacheChildrenManInTheMiddle.add(successfulManInTheMiddle);
      }
      for (AttackStep attackStep : _cacheChildrenManInTheMiddle) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentManInTheMiddle == null) {
        _cacheParentManInTheMiddle = new HashSet<>();
        _cacheParentManInTheMiddle.add(accessNetworkData);
        _cacheParentManInTheMiddle.add(manInTheMiddleDefense.disable);
      }
      for (AttackStep attackStep : _cacheParentManInTheMiddle) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.manInTheMiddle");
    }
  }

  public class BypassMitMProtection extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassMitMProtection;

    private Set<AttackStep> _cacheParentBypassMitMProtection;

    public BypassMitMProtection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassMitMProtection == null) {
        _cacheChildrenBypassMitMProtection = new HashSet<>();
        _cacheChildrenBypassMitMProtection.add(successfulManInTheMiddle);
      }
      for (AttackStep attackStep : _cacheChildrenBypassMitMProtection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassMitMProtection == null) {
        _cacheParentBypassMitMProtection = new HashSet<>();
        _cacheParentBypassMitMProtection.add(accessNetworkData);
      }
      for (AttackStep attackStep : _cacheParentBypassMitMProtection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassMitMProtection");
    }
  }

  public class SuccessfulManInTheMiddle extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenSuccessfulManInTheMiddle;

    private Set<AttackStep> _cacheParentSuccessfulManInTheMiddle;

    public SuccessfulManInTheMiddle(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulManInTheMiddle == null) {
        _cacheChildrenSuccessfulManInTheMiddle = new HashSet<>();
        for (Data _0 : transitData) {
          _cacheChildrenSuccessfulManInTheMiddle.add(_0.attemptRead);
        }
        for (Data _1 : transitData) {
          _cacheChildrenSuccessfulManInTheMiddle.add(_1.attemptWrite);
        }
        for (Data _2 : transitData) {
          _cacheChildrenSuccessfulManInTheMiddle.add(_2.attemptApplicationRespondConnect);
        }
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulManInTheMiddle) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulManInTheMiddle == null) {
        _cacheParentSuccessfulManInTheMiddle = new HashSet<>();
        _cacheParentSuccessfulManInTheMiddle.add(manInTheMiddle);
        _cacheParentSuccessfulManInTheMiddle.add(bypassMitMProtection);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulManInTheMiddle) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.successfulManInTheMiddle");
    }
  }

  public class EavesdropAfterPhysicalAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenEavesdropAfterPhysicalAccess;

    private Set<AttackStep> _cacheParentEavesdropAfterPhysicalAccess;

    public EavesdropAfterPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenEavesdropAfterPhysicalAccess == null) {
        _cacheChildrenEavesdropAfterPhysicalAccess = new HashSet<>();
        _cacheChildrenEavesdropAfterPhysicalAccess.add(successfulEavesdrop);
      }
      for (AttackStep attackStep : _cacheChildrenEavesdropAfterPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentEavesdropAfterPhysicalAccess == null) {
        _cacheParentEavesdropAfterPhysicalAccess = new HashSet<>();
        _cacheParentEavesdropAfterPhysicalAccess.add(physicalAccess);
        _cacheParentEavesdropAfterPhysicalAccess.add(networkAccessControl.disable);
        _cacheParentEavesdropAfterPhysicalAccess.add(eavesdropDefense.disable);
      }
      for (AttackStep attackStep : _cacheParentEavesdropAfterPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.eavesdropAfterPhysicalAccess");
    }
  }
}
