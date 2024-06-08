package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class ConnectionRule extends Asset {
  public Restricted restricted;

  public BypassRestricted bypassRestricted;

  public RestrictedBypassed restrictedBypassed;

  public PayloadInspection payloadInspection;

  public BypassPayloadInspection bypassPayloadInspection;

  public PayloadInspectionBypassed payloadInspectionBypassed;

  public AttemptReverseReach attemptReverseReach;

  public ReverseReach reverseReach;

  public AttemptAccessNetworksUninspected attemptAccessNetworksUninspected;

  public AttemptAccessNetworksInspected attemptAccessNetworksInspected;

  public SuccessfulAccessNetworksUninspected successfulAccessNetworksUninspected;

  public SuccessfulAccessNetworksInspected successfulAccessNetworksInspected;

  public AccessNetworksUninspected accessNetworksUninspected;

  public AccessNetworksInspected accessNetworksInspected;

  public AttemptConnectToApplicationsUninspected attemptConnectToApplicationsUninspected;

  public AttemptConnectToApplicationsInspected attemptConnectToApplicationsInspected;

  public ConnectToApplicationsUninspected connectToApplicationsUninspected;

  public ConnectToApplicationsInspected connectToApplicationsInspected;

  public AttemptDeny attemptDeny;

  public Deny deny;

  private Set<Application> _cachesenderApplicationsConnectionRule;

  private Set<Application> _cachereceiverApplicationsConnectionRule;

  private Set<Application> _cacheallApplicationsConnectionRule;

  private Set<Application> _cachereverseingoingApplicationConnectionsApplication;

  private Set<Application> _cachereverseoutgoingApplicationConnectionsApplication;

  private Set<Data> _cachereversesenderOutgoingApplicationConnectionsData;

  private Set<Data> _cachereversetransitNetworkInboundAllowedConnectionsData;

  private Set<Data> _cachereversereceiverIngoingApplicationConnectionsData;

  private Set<Data> _cachereversetransitNetworkOutboundAllowedConnectionsData;

  private Set<Network> _cachereverseoutboundAllowedConnectionsNetwork;

  private Set<Network> _cachereverseinboundAllowedConnectionsNetwork;

  private Set<Network> _cachereverseallNetConnectionsNetwork;

  public RoutingFirewall routingFirewalls = null;

  public Set<Application> applications = new HashSet<>();

  public Set<Application> inApplications = new HashSet<>();

  public Set<Application> outApplications = new HashSet<>();

  public Set<Network> networks = new HashSet<>();

  public Set<Network> inNetworks = new HashSet<>();

  public Set<Network> outNetworks = new HashSet<>();

  public Set<Network> diodeInNetworks = new HashSet<>();

  public ConnectionRule(String name, boolean isRestrictedEnabled,
      boolean isPayloadInspectionEnabled) {
    super(name);
    assetClassName = "ConnectionRule";
    if (restricted != null) {
      AttackStep.allAttackSteps.remove(restricted.disable);
    }
    Defense.allDefenses.remove(restricted);
    restricted = new Restricted(name, isRestrictedEnabled);
    AttackStep.allAttackSteps.remove(bypassRestricted);
    bypassRestricted = new BypassRestricted(name);
    AttackStep.allAttackSteps.remove(restrictedBypassed);
    restrictedBypassed = new RestrictedBypassed(name);
    if (payloadInspection != null) {
      AttackStep.allAttackSteps.remove(payloadInspection.disable);
    }
    Defense.allDefenses.remove(payloadInspection);
    payloadInspection = new PayloadInspection(name, isPayloadInspectionEnabled);
    AttackStep.allAttackSteps.remove(bypassPayloadInspection);
    bypassPayloadInspection = new BypassPayloadInspection(name);
    AttackStep.allAttackSteps.remove(payloadInspectionBypassed);
    payloadInspectionBypassed = new PayloadInspectionBypassed(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(attemptAccessNetworksUninspected);
    attemptAccessNetworksUninspected = new AttemptAccessNetworksUninspected(name);
    AttackStep.allAttackSteps.remove(attemptAccessNetworksInspected);
    attemptAccessNetworksInspected = new AttemptAccessNetworksInspected(name);
    AttackStep.allAttackSteps.remove(successfulAccessNetworksUninspected);
    successfulAccessNetworksUninspected = new SuccessfulAccessNetworksUninspected(name);
    AttackStep.allAttackSteps.remove(successfulAccessNetworksInspected);
    successfulAccessNetworksInspected = new SuccessfulAccessNetworksInspected(name);
    AttackStep.allAttackSteps.remove(accessNetworksUninspected);
    accessNetworksUninspected = new AccessNetworksUninspected(name);
    AttackStep.allAttackSteps.remove(accessNetworksInspected);
    accessNetworksInspected = new AccessNetworksInspected(name);
    AttackStep.allAttackSteps.remove(attemptConnectToApplicationsUninspected);
    attemptConnectToApplicationsUninspected = new AttemptConnectToApplicationsUninspected(name);
    AttackStep.allAttackSteps.remove(attemptConnectToApplicationsInspected);
    attemptConnectToApplicationsInspected = new AttemptConnectToApplicationsInspected(name);
    AttackStep.allAttackSteps.remove(connectToApplicationsUninspected);
    connectToApplicationsUninspected = new ConnectToApplicationsUninspected(name);
    AttackStep.allAttackSteps.remove(connectToApplicationsInspected);
    connectToApplicationsInspected = new ConnectToApplicationsInspected(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
  }

  public ConnectionRule(String name) {
    super(name);
    assetClassName = "ConnectionRule";
    if (restricted != null) {
      AttackStep.allAttackSteps.remove(restricted.disable);
    }
    Defense.allDefenses.remove(restricted);
    restricted = new Restricted(name, false);
    AttackStep.allAttackSteps.remove(bypassRestricted);
    bypassRestricted = new BypassRestricted(name);
    AttackStep.allAttackSteps.remove(restrictedBypassed);
    restrictedBypassed = new RestrictedBypassed(name);
    if (payloadInspection != null) {
      AttackStep.allAttackSteps.remove(payloadInspection.disable);
    }
    Defense.allDefenses.remove(payloadInspection);
    payloadInspection = new PayloadInspection(name, false);
    AttackStep.allAttackSteps.remove(bypassPayloadInspection);
    bypassPayloadInspection = new BypassPayloadInspection(name);
    AttackStep.allAttackSteps.remove(payloadInspectionBypassed);
    payloadInspectionBypassed = new PayloadInspectionBypassed(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(attemptAccessNetworksUninspected);
    attemptAccessNetworksUninspected = new AttemptAccessNetworksUninspected(name);
    AttackStep.allAttackSteps.remove(attemptAccessNetworksInspected);
    attemptAccessNetworksInspected = new AttemptAccessNetworksInspected(name);
    AttackStep.allAttackSteps.remove(successfulAccessNetworksUninspected);
    successfulAccessNetworksUninspected = new SuccessfulAccessNetworksUninspected(name);
    AttackStep.allAttackSteps.remove(successfulAccessNetworksInspected);
    successfulAccessNetworksInspected = new SuccessfulAccessNetworksInspected(name);
    AttackStep.allAttackSteps.remove(accessNetworksUninspected);
    accessNetworksUninspected = new AccessNetworksUninspected(name);
    AttackStep.allAttackSteps.remove(accessNetworksInspected);
    accessNetworksInspected = new AccessNetworksInspected(name);
    AttackStep.allAttackSteps.remove(attemptConnectToApplicationsUninspected);
    attemptConnectToApplicationsUninspected = new AttemptConnectToApplicationsUninspected(name);
    AttackStep.allAttackSteps.remove(attemptConnectToApplicationsInspected);
    attemptConnectToApplicationsInspected = new AttemptConnectToApplicationsInspected(name);
    AttackStep.allAttackSteps.remove(connectToApplicationsUninspected);
    connectToApplicationsUninspected = new ConnectToApplicationsUninspected(name);
    AttackStep.allAttackSteps.remove(connectToApplicationsInspected);
    connectToApplicationsInspected = new ConnectToApplicationsInspected(name);
    AttackStep.allAttackSteps.remove(attemptDeny);
    attemptDeny = new AttemptDeny(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
  }

  public ConnectionRule(boolean isRestrictedEnabled, boolean isPayloadInspectionEnabled) {
    this("Anonymous", isRestrictedEnabled, isPayloadInspectionEnabled);
  }

  public ConnectionRule() {
    this("Anonymous");
  }

  protected Set<Application> _senderApplicationsConnectionRule() {
    if (_cachesenderApplicationsConnectionRule == null) {
      _cachesenderApplicationsConnectionRule = new HashSet<>();
      Set<Application> _1 = new HashSet<>();
      Set<Application> _2 = new HashSet<>();
      for (Application _3 : applications) {
        _1.add(_3);
      }
      for (Application _4 : outApplications) {
        _2.add(_4);
      }
      _1.addAll(_2);
      for (Application _5 : _1) {
        _cachesenderApplicationsConnectionRule.add(_5);
      }
    }
    return _cachesenderApplicationsConnectionRule;
  }

  protected Set<Application> _receiverApplicationsConnectionRule() {
    if (_cachereceiverApplicationsConnectionRule == null) {
      _cachereceiverApplicationsConnectionRule = new HashSet<>();
      Set<Application> _6 = new HashSet<>();
      Set<Application> _7 = new HashSet<>();
      for (Application _8 : applications) {
        _6.add(_8);
      }
      for (Application _9 : inApplications) {
        _7.add(_9);
      }
      _6.addAll(_7);
      for (Application _a : _6) {
        _cachereceiverApplicationsConnectionRule.add(_a);
      }
    }
    return _cachereceiverApplicationsConnectionRule;
  }

  protected Set<Application> _allApplicationsConnectionRule() {
    if (_cacheallApplicationsConnectionRule == null) {
      _cacheallApplicationsConnectionRule = new HashSet<>();
      Set<Application> _b = new HashSet<>();
      Set<Application> _c = new HashSet<>();
      Set<Application> _d = new HashSet<>();
      Set<Application> _e = new HashSet<>();
      for (Application _f : applications) {
        _d.add(_f);
      }
      for (Application _10 : inApplications) {
        _e.add(_10);
      }
      _d.addAll(_e);
      for (Application _11 : _d) {
        _b.add(_11);
      }
      for (Application _12 : outApplications) {
        _c.add(_12);
      }
      _b.addAll(_c);
      for (Application _13 : _b) {
        _cacheallApplicationsConnectionRule.add(_13);
      }
    }
    return _cacheallApplicationsConnectionRule;
  }

  protected Set<Application> _reverseingoingApplicationConnectionsApplication() {
    if (_cachereverseingoingApplicationConnectionsApplication == null) {
      _cachereverseingoingApplicationConnectionsApplication = new HashSet<>();
      Set<Application> _14 = new HashSet<>();
      Set<Application> _15 = new HashSet<>();
      for (Application _16 : inApplications) {
        _14.add(_16);
      }
      for (Application _17 : applications) {
        _15.add(_17);
      }
      _14.addAll(_15);
      for (Application _18 : _14) {
        _cachereverseingoingApplicationConnectionsApplication.add(_18);
      }
    }
    return _cachereverseingoingApplicationConnectionsApplication;
  }

  protected Set<Application> _reverseoutgoingApplicationConnectionsApplication() {
    if (_cachereverseoutgoingApplicationConnectionsApplication == null) {
      _cachereverseoutgoingApplicationConnectionsApplication = new HashSet<>();
      Set<Application> _19 = new HashSet<>();
      Set<Application> _1a = new HashSet<>();
      for (Application _1b : outApplications) {
        _19.add(_1b);
      }
      for (Application _1c : applications) {
        _1a.add(_1c);
      }
      _19.addAll(_1a);
      for (Application _1d : _19) {
        _cachereverseoutgoingApplicationConnectionsApplication.add(_1d);
      }
    }
    return _cachereverseoutgoingApplicationConnectionsApplication;
  }

  protected Set<Data> _reversesenderOutgoingApplicationConnectionsData() {
    if (_cachereversesenderOutgoingApplicationConnectionsData == null) {
      _cachereversesenderOutgoingApplicationConnectionsData = new HashSet<>();
      Set<Data> _1e = new HashSet<>();
      Set<Data> _1f = new HashSet<>();
      for (Application _20 : outApplications) {
        for (Data _21 : _20.sentData) {
          _1e.add(_21);
        }
      }
      for (Application _22 : applications) {
        for (Data _23 : _22.sentData) {
          _1f.add(_23);
        }
      }
      _1e.addAll(_1f);
      for (Data _24 : _1e) {
        _cachereversesenderOutgoingApplicationConnectionsData.add(_24);
      }
    }
    return _cachereversesenderOutgoingApplicationConnectionsData;
  }

  protected Set<Data> _reversetransitNetworkInboundAllowedConnectionsData() {
    if (_cachereversetransitNetworkInboundAllowedConnectionsData == null) {
      _cachereversetransitNetworkInboundAllowedConnectionsData = new HashSet<>();
      Set<Data> _25 = new HashSet<>();
      Set<Data> _26 = new HashSet<>();
      for (Network _27 : diodeInNetworks) {
        for (Data _28 : _27.transitData) {
          _25.add(_28);
        }
      }
      Set<Data> _29 = new HashSet<>();
      Set<Data> _2a = new HashSet<>();
      for (Network _2b : inNetworks) {
        for (Data _2c : _2b.transitData) {
          _29.add(_2c);
        }
      }
      for (Network _2d : networks) {
        for (Data _2e : _2d.transitData) {
          _2a.add(_2e);
        }
      }
      _29.addAll(_2a);
      for (Data _2f : _29) {
        _26.add(_2f);
      }
      _25.addAll(_26);
      for (Data _30 : _25) {
        _cachereversetransitNetworkInboundAllowedConnectionsData.add(_30);
      }
    }
    return _cachereversetransitNetworkInboundAllowedConnectionsData;
  }

  protected Set<Data> _reversereceiverIngoingApplicationConnectionsData() {
    if (_cachereversereceiverIngoingApplicationConnectionsData == null) {
      _cachereversereceiverIngoingApplicationConnectionsData = new HashSet<>();
      Set<Data> _31 = new HashSet<>();
      Set<Data> _32 = new HashSet<>();
      for (Application _33 : inApplications) {
        for (Data _34 : _33.receivedData) {
          _31.add(_34);
        }
      }
      for (Application _35 : applications) {
        for (Data _36 : _35.receivedData) {
          _32.add(_36);
        }
      }
      _31.addAll(_32);
      for (Data _37 : _31) {
        _cachereversereceiverIngoingApplicationConnectionsData.add(_37);
      }
    }
    return _cachereversereceiverIngoingApplicationConnectionsData;
  }

  protected Set<Data> _reversetransitNetworkOutboundAllowedConnectionsData() {
    if (_cachereversetransitNetworkOutboundAllowedConnectionsData == null) {
      _cachereversetransitNetworkOutboundAllowedConnectionsData = new HashSet<>();
      Set<Data> _38 = new HashSet<>();
      Set<Data> _39 = new HashSet<>();
      for (Network _3a : outNetworks) {
        for (Data _3b : _3a.transitData) {
          _38.add(_3b);
        }
      }
      for (Network _3c : networks) {
        for (Data _3d : _3c.transitData) {
          _39.add(_3d);
        }
      }
      _38.addAll(_39);
      for (Data _3e : _38) {
        _cachereversetransitNetworkOutboundAllowedConnectionsData.add(_3e);
      }
    }
    return _cachereversetransitNetworkOutboundAllowedConnectionsData;
  }

  protected Set<Network> _reverseoutboundAllowedConnectionsNetwork() {
    if (_cachereverseoutboundAllowedConnectionsNetwork == null) {
      _cachereverseoutboundAllowedConnectionsNetwork = new HashSet<>();
      Set<Network> _3f = new HashSet<>();
      Set<Network> _40 = new HashSet<>();
      for (Network _41 : outNetworks) {
        _3f.add(_41);
      }
      for (Network _42 : networks) {
        _40.add(_42);
      }
      _3f.addAll(_40);
      for (Network _43 : _3f) {
        _cachereverseoutboundAllowedConnectionsNetwork.add(_43);
      }
    }
    return _cachereverseoutboundAllowedConnectionsNetwork;
  }

  protected Set<Network> _reverseinboundAllowedConnectionsNetwork() {
    if (_cachereverseinboundAllowedConnectionsNetwork == null) {
      _cachereverseinboundAllowedConnectionsNetwork = new HashSet<>();
      Set<Network> _44 = new HashSet<>();
      Set<Network> _45 = new HashSet<>();
      for (Network _46 : diodeInNetworks) {
        _44.add(_46);
      }
      Set<Network> _47 = new HashSet<>();
      Set<Network> _48 = new HashSet<>();
      for (Network _49 : inNetworks) {
        _47.add(_49);
      }
      for (Network _4a : networks) {
        _48.add(_4a);
      }
      _47.addAll(_48);
      for (Network _4b : _47) {
        _45.add(_4b);
      }
      _44.addAll(_45);
      for (Network _4c : _44) {
        _cachereverseinboundAllowedConnectionsNetwork.add(_4c);
      }
    }
    return _cachereverseinboundAllowedConnectionsNetwork;
  }

  protected Set<Network> _reverseallNetConnectionsNetwork() {
    if (_cachereverseallNetConnectionsNetwork == null) {
      _cachereverseallNetConnectionsNetwork = new HashSet<>();
      Set<Network> _4d = new HashSet<>();
      Set<Network> _4e = new HashSet<>();
      for (Network _4f : diodeInNetworks) {
        _4d.add(_4f);
      }
      Set<Network> _50 = new HashSet<>();
      Set<Network> _51 = new HashSet<>();
      for (Network _52 : outNetworks) {
        _50.add(_52);
      }
      Set<Network> _53 = new HashSet<>();
      Set<Network> _54 = new HashSet<>();
      for (Network _55 : inNetworks) {
        _53.add(_55);
      }
      for (Network _56 : networks) {
        _54.add(_56);
      }
      _53.addAll(_54);
      for (Network _57 : _53) {
        _51.add(_57);
      }
      _50.addAll(_51);
      for (Network _58 : _50) {
        _4e.add(_58);
      }
      _4d.addAll(_4e);
      for (Network _59 : _4d) {
        _cachereverseallNetConnectionsNetwork.add(_59);
      }
    }
    return _cachereverseallNetConnectionsNetwork;
  }

  public void addRoutingFirewalls(RoutingFirewall routingFirewalls) {
    this.routingFirewalls = routingFirewalls;
    routingFirewalls.connectionRules.add(this);
  }

  public void addApplications(Application applications) {
    this.applications.add(applications);
    applications.appConnections.add(this);
  }

  public void addInApplications(Application inApplications) {
    this.inApplications.add(inApplications);
    inApplications.ingoingAppConnections.add(this);
  }

  public void addOutApplications(Application outApplications) {
    this.outApplications.add(outApplications);
    outApplications.outgoingAppConnections.add(this);
  }

  public void addNetworks(Network networks) {
    this.networks.add(networks);
    networks.netConnections.add(this);
  }

  public void addInNetworks(Network inNetworks) {
    this.inNetworks.add(inNetworks);
    inNetworks.ingoingNetConnections.add(this);
  }

  public void addOutNetworks(Network outNetworks) {
    this.outNetworks.add(outNetworks);
    outNetworks.outgoingNetConnections.add(this);
  }

  public void addDiodeInNetworks(Network diodeInNetworks) {
    this.diodeInNetworks.add(diodeInNetworks);
    diodeInNetworks.diodeIngoingNetConnections.add(this);
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("routingFirewalls")) {
      return RoutingFirewall.class.getName();
    } else if (field.equals("applications")) {
      return Application.class.getName();
    } else if (field.equals("inApplications")) {
      return Application.class.getName();
    } else if (field.equals("outApplications")) {
      return Application.class.getName();
    } else if (field.equals("networks")) {
      return Network.class.getName();
    } else if (field.equals("inNetworks")) {
      return Network.class.getName();
    } else if (field.equals("outNetworks")) {
      return Network.class.getName();
    } else if (field.equals("diodeInNetworks")) {
      return Network.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("routingFirewalls")) {
      if (routingFirewalls != null) {
        assets.add(routingFirewalls);
      }
    } else if (field.equals("applications")) {
      assets.addAll(applications);
    } else if (field.equals("inApplications")) {
      assets.addAll(inApplications);
    } else if (field.equals("outApplications")) {
      assets.addAll(outApplications);
    } else if (field.equals("networks")) {
      assets.addAll(networks);
    } else if (field.equals("inNetworks")) {
      assets.addAll(inNetworks);
    } else if (field.equals("outNetworks")) {
      assets.addAll(outNetworks);
    } else if (field.equals("diodeInNetworks")) {
      assets.addAll(diodeInNetworks);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    if (routingFirewalls != null) {
      assets.add(routingFirewalls);
    }
    assets.addAll(applications);
    assets.addAll(inApplications);
    assets.addAll(outApplications);
    assets.addAll(networks);
    assets.addAll(inNetworks);
    assets.addAll(outNetworks);
    assets.addAll(diodeInNetworks);
    return assets;
  }

  public class Restricted extends Defense {
    public Restricted(String name) {
      this(name, false);
    }

    public Restricted(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenRestricted;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenRestricted == null) {
          _cacheChildrenRestricted = new HashSet<>();
          _cacheChildrenRestricted.add(restrictedBypassed);
        }
        for (AttackStep attackStep : _cacheChildrenRestricted) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "ConnectionRule.restricted";
      }
    }
  }

  public class BypassRestricted extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassRestricted;

    private Set<AttackStep> _cacheParentBypassRestricted;

    public BypassRestricted(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassRestricted == null) {
        _cacheChildrenBypassRestricted = new HashSet<>();
        _cacheChildrenBypassRestricted.add(restrictedBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassRestricted) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassRestricted == null) {
        _cacheParentBypassRestricted = new HashSet<>();
        _cacheParentBypassRestricted.add(attemptReverseReach);
        _cacheParentBypassRestricted.add(attemptAccessNetworksUninspected);
        _cacheParentBypassRestricted.add(attemptAccessNetworksInspected);
        _cacheParentBypassRestricted.add(attemptConnectToApplicationsUninspected);
        _cacheParentBypassRestricted.add(attemptConnectToApplicationsInspected);
        _cacheParentBypassRestricted.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheParentBypassRestricted) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.bypassRestricted");
    }
  }

  public class RestrictedBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenRestrictedBypassed;

    private Set<AttackStep> _cacheParentRestrictedBypassed;

    public RestrictedBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenRestrictedBypassed == null) {
        _cacheChildrenRestrictedBypassed = new HashSet<>();
        _cacheChildrenRestrictedBypassed.add(successfulAccessNetworksUninspected);
        _cacheChildrenRestrictedBypassed.add(successfulAccessNetworksInspected);
        _cacheChildrenRestrictedBypassed.add(connectToApplicationsUninspected);
        _cacheChildrenRestrictedBypassed.add(connectToApplicationsInspected);
        _cacheChildrenRestrictedBypassed.add(deny);
        _cacheChildrenRestrictedBypassed.add(reverseReach);
      }
      for (AttackStep attackStep : _cacheChildrenRestrictedBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentRestrictedBypassed == null) {
        _cacheParentRestrictedBypassed = new HashSet<>();
        _cacheParentRestrictedBypassed.add(restricted.disable);
        _cacheParentRestrictedBypassed.add(bypassRestricted);
      }
      for (AttackStep attackStep : _cacheParentRestrictedBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.restrictedBypassed");
    }
  }

  public class PayloadInspection extends Defense {
    public PayloadInspection(String name) {
      this(name, false);
    }

    public PayloadInspection(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenPayloadInspection;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenPayloadInspection == null) {
          _cacheChildrenPayloadInspection = new HashSet<>();
          _cacheChildrenPayloadInspection.add(payloadInspectionBypassed);
        }
        for (AttackStep attackStep : _cacheChildrenPayloadInspection) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "ConnectionRule.payloadInspection";
      }
    }
  }

  public class BypassPayloadInspection extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassPayloadInspection;

    private Set<AttackStep> _cacheParentBypassPayloadInspection;

    public BypassPayloadInspection(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassPayloadInspection == null) {
        _cacheChildrenBypassPayloadInspection = new HashSet<>();
        _cacheChildrenBypassPayloadInspection.add(payloadInspectionBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassPayloadInspection) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassPayloadInspection == null) {
        _cacheParentBypassPayloadInspection = new HashSet<>();
        _cacheParentBypassPayloadInspection.add(attemptReverseReach);
        _cacheParentBypassPayloadInspection.add(attemptConnectToApplicationsUninspected);
        _cacheParentBypassPayloadInspection.add(attemptConnectToApplicationsInspected);
      }
      for (AttackStep attackStep : _cacheParentBypassPayloadInspection) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.bypassPayloadInspection");
    }
  }

  public class PayloadInspectionBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenPayloadInspectionBypassed;

    private Set<AttackStep> _cacheParentPayloadInspectionBypassed;

    public PayloadInspectionBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenPayloadInspectionBypassed == null) {
        _cacheChildrenPayloadInspectionBypassed = new HashSet<>();
        _cacheChildrenPayloadInspectionBypassed.add(successfulAccessNetworksUninspected);
        _cacheChildrenPayloadInspectionBypassed.add(connectToApplicationsUninspected);
        _cacheChildrenPayloadInspectionBypassed.add(reverseReach);
      }
      for (AttackStep attackStep : _cacheChildrenPayloadInspectionBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentPayloadInspectionBypassed == null) {
        _cacheParentPayloadInspectionBypassed = new HashSet<>();
        Set<Data> _0 = new HashSet<>();
        Set<Data> _1 = new HashSet<>();
        for (var _2 : _reversetransitNetworkInboundAllowedConnectionsData()) {
          _0.add(_2);
        }
        for (var _3 : _reversesenderOutgoingApplicationConnectionsData()) {
          _1.add(_3);
        }
        _0.retainAll(_1);
        for (Data _4 : _0) {
          _cacheParentPayloadInspectionBypassed.add(_4.bypassPayloadInspectionFromEncryptedData);
        }
        Set<Data> _5 = new HashSet<>();
        Set<Data> _6 = new HashSet<>();
        for (var _7 : _reversetransitNetworkOutboundAllowedConnectionsData()) {
          _5.add(_7);
        }
        for (var _8 : _reversereceiverIngoingApplicationConnectionsData()) {
          _6.add(_8);
        }
        _5.retainAll(_6);
        for (Data _9 : _5) {
          _cacheParentPayloadInspectionBypassed.add(_9.bypassPayloadInspectionFromEncryptedData);
        }
        _cacheParentPayloadInspectionBypassed.add(payloadInspection.disable);
        _cacheParentPayloadInspectionBypassed.add(bypassPayloadInspection);
      }
      for (AttackStep attackStep : _cacheParentPayloadInspectionBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.payloadInspectionBypassed");
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
        _cacheChildrenAttemptReverseReach.add(bypassRestricted);
        _cacheChildrenAttemptReverseReach.add(bypassPayloadInspection);
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
        for (var _0 : _reverseingoingApplicationConnectionsApplication()) {
          _cacheParentAttemptReverseReach.add(_0.reverseReach);
        }
        for (var _1 : _reverseinboundAllowedConnectionsNetwork()) {
          _cacheParentAttemptReverseReach.add(_1.reverseReach);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptReverseReach");
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
        for (var _0 : _senderApplicationsConnectionRule()) {
          _cacheChildrenReverseReach.add(_0.attemptReverseReach);
        }
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        for (Network _3 : networks) {
          _1.add(_3);
        }
        for (Network _4 : outNetworks) {
          _2.add(_4);
        }
        _1.addAll(_2);
        for (Network _5 : _1) {
          _cacheChildrenReverseReach.add(_5.attemptReverseReach);
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
        _cacheParentReverseReach.add(restrictedBypassed);
        _cacheParentReverseReach.add(payloadInspectionBypassed);
        _cacheParentReverseReach.add(attemptReverseReach);
      }
      for (AttackStep attackStep : _cacheParentReverseReach) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.reverseReach");
    }
  }

  public class AttemptAccessNetworksUninspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAccessNetworksUninspected;

    private Set<AttackStep> _cacheParentAttemptAccessNetworksUninspected;

    public AttemptAccessNetworksUninspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccessNetworksUninspected == null) {
        _cacheChildrenAttemptAccessNetworksUninspected = new HashSet<>();
        _cacheChildrenAttemptAccessNetworksUninspected.add(successfulAccessNetworksUninspected);
        _cacheChildrenAttemptAccessNetworksUninspected.add(bypassRestricted);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccessNetworksUninspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccessNetworksUninspected == null) {
        _cacheParentAttemptAccessNetworksUninspected = new HashSet<>();
        for (var _0 : _reverseoutgoingApplicationConnectionsApplication()) {
          _cacheParentAttemptAccessNetworksUninspected.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseoutboundAllowedConnectionsNetwork()) {
          _cacheParentAttemptAccessNetworksUninspected.add(_1.networkForwardingUninspected);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAccessNetworksUninspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptAccessNetworksUninspected");
    }
  }

  public class AttemptAccessNetworksInspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAccessNetworksInspected;

    private Set<AttackStep> _cacheParentAttemptAccessNetworksInspected;

    public AttemptAccessNetworksInspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccessNetworksInspected == null) {
        _cacheChildrenAttemptAccessNetworksInspected = new HashSet<>();
        _cacheChildrenAttemptAccessNetworksInspected.add(successfulAccessNetworksInspected);
        _cacheChildrenAttemptAccessNetworksInspected.add(bypassRestricted);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccessNetworksInspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccessNetworksInspected == null) {
        _cacheParentAttemptAccessNetworksInspected = new HashSet<>();
        for (var _0 : _reverseoutgoingApplicationConnectionsApplication()) {
          _cacheParentAttemptAccessNetworksInspected.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseoutboundAllowedConnectionsNetwork()) {
          _cacheParentAttemptAccessNetworksInspected.add(_1.networkForwardingInspected);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptAccessNetworksInspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptAccessNetworksInspected");
    }
  }

  public class SuccessfulAccessNetworksUninspected extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulAccessNetworksUninspected;

    private Set<AttackStep> _cacheParentSuccessfulAccessNetworksUninspected;

    public SuccessfulAccessNetworksUninspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAccessNetworksUninspected == null) {
        _cacheChildrenSuccessfulAccessNetworksUninspected = new HashSet<>();
        _cacheChildrenSuccessfulAccessNetworksUninspected.add(accessNetworksUninspected);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAccessNetworksUninspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulAccessNetworksUninspected == null) {
        _cacheParentSuccessfulAccessNetworksUninspected = new HashSet<>();
        _cacheParentSuccessfulAccessNetworksUninspected.add(restrictedBypassed);
        _cacheParentSuccessfulAccessNetworksUninspected.add(payloadInspectionBypassed);
        _cacheParentSuccessfulAccessNetworksUninspected.add(attemptAccessNetworksUninspected);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAccessNetworksUninspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.successfulAccessNetworksUninspected");
    }
  }

  public class SuccessfulAccessNetworksInspected extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulAccessNetworksInspected;

    private Set<AttackStep> _cacheParentSuccessfulAccessNetworksInspected;

    public SuccessfulAccessNetworksInspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAccessNetworksInspected == null) {
        _cacheChildrenSuccessfulAccessNetworksInspected = new HashSet<>();
        _cacheChildrenSuccessfulAccessNetworksInspected.add(accessNetworksInspected);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAccessNetworksInspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulAccessNetworksInspected == null) {
        _cacheParentSuccessfulAccessNetworksInspected = new HashSet<>();
        _cacheParentSuccessfulAccessNetworksInspected.add(restrictedBypassed);
        _cacheParentSuccessfulAccessNetworksInspected.add(attemptAccessNetworksInspected);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAccessNetworksInspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.successfulAccessNetworksInspected");
    }
  }

  public class AccessNetworksUninspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessNetworksUninspected;

    private Set<AttackStep> _cacheParentAccessNetworksUninspected;

    public AccessNetworksUninspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessNetworksUninspected == null) {
        _cacheChildrenAccessNetworksUninspected = new HashSet<>();
        Set<Network> _0 = new HashSet<>();
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        Set<Network> _3 = new HashSet<>();
        for (Network _4 : networks) {
          _2.add(_4);
        }
        for (Network _5 : inNetworks) {
          _3.add(_5);
        }
        _2.addAll(_3);
        for (Network _6 : _2) {
          _0.add(_6);
        }
        for (Network _7 : diodeInNetworks) {
          _1.add(_7);
        }
        _0.addAll(_1);
        for (Network _8 : _0) {
          _cacheChildrenAccessNetworksUninspected.add(_8.accessUninspected);
        }
        _cacheChildrenAccessNetworksUninspected.add(accessNetworksInspected);
      }
      for (AttackStep attackStep : _cacheChildrenAccessNetworksUninspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessNetworksUninspected == null) {
        _cacheParentAccessNetworksUninspected = new HashSet<>();
        _cacheParentAccessNetworksUninspected.add(successfulAccessNetworksUninspected);
      }
      for (AttackStep attackStep : _cacheParentAccessNetworksUninspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.accessNetworksUninspected");
    }
  }

  public class AccessNetworksInspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessNetworksInspected;

    private Set<AttackStep> _cacheParentAccessNetworksInspected;

    public AccessNetworksInspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessNetworksInspected == null) {
        _cacheChildrenAccessNetworksInspected = new HashSet<>();
        Set<Network> _0 = new HashSet<>();
        Set<Network> _1 = new HashSet<>();
        Set<Network> _2 = new HashSet<>();
        Set<Network> _3 = new HashSet<>();
        for (Network _4 : networks) {
          _2.add(_4);
        }
        for (Network _5 : inNetworks) {
          _3.add(_5);
        }
        _2.addAll(_3);
        for (Network _6 : _2) {
          _0.add(_6);
        }
        for (Network _7 : diodeInNetworks) {
          _1.add(_7);
        }
        _0.addAll(_1);
        for (Network _8 : _0) {
          _cacheChildrenAccessNetworksInspected.add(_8.accessInspected);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAccessNetworksInspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessNetworksInspected == null) {
        _cacheParentAccessNetworksInspected = new HashSet<>();
        _cacheParentAccessNetworksInspected.add(successfulAccessNetworksInspected);
        _cacheParentAccessNetworksInspected.add(accessNetworksUninspected);
      }
      for (AttackStep attackStep : _cacheParentAccessNetworksInspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.accessNetworksInspected");
    }
  }

  public class AttemptConnectToApplicationsUninspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptConnectToApplicationsUninspected;

    private Set<AttackStep> _cacheParentAttemptConnectToApplicationsUninspected;

    public AttemptConnectToApplicationsUninspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptConnectToApplicationsUninspected == null) {
        _cacheChildrenAttemptConnectToApplicationsUninspected = new HashSet<>();
        _cacheChildrenAttemptConnectToApplicationsUninspected.add(connectToApplicationsUninspected);
        _cacheChildrenAttemptConnectToApplicationsUninspected.add(bypassRestricted);
        _cacheChildrenAttemptConnectToApplicationsUninspected.add(bypassPayloadInspection);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptConnectToApplicationsUninspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptConnectToApplicationsUninspected == null) {
        _cacheParentAttemptConnectToApplicationsUninspected = new HashSet<>();
        for (var _0 : _reverseoutgoingApplicationConnectionsApplication()) {
          _cacheParentAttemptConnectToApplicationsUninspected.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseoutboundAllowedConnectionsNetwork()) {
          _cacheParentAttemptConnectToApplicationsUninspected.add(_1.accessUninspected);
        }
        for (var _2 : _reverseoutboundAllowedConnectionsNetwork()) {
          _cacheParentAttemptConnectToApplicationsUninspected.add(_2.networkForwardingUninspected);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptConnectToApplicationsUninspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptConnectToApplicationsUninspected");
    }
  }

  public class AttemptConnectToApplicationsInspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptConnectToApplicationsInspected;

    private Set<AttackStep> _cacheParentAttemptConnectToApplicationsInspected;

    public AttemptConnectToApplicationsInspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptConnectToApplicationsInspected == null) {
        _cacheChildrenAttemptConnectToApplicationsInspected = new HashSet<>();
        _cacheChildrenAttemptConnectToApplicationsInspected.add(connectToApplicationsInspected);
        _cacheChildrenAttemptConnectToApplicationsInspected.add(bypassRestricted);
        _cacheChildrenAttemptConnectToApplicationsInspected.add(bypassPayloadInspection);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptConnectToApplicationsInspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptConnectToApplicationsInspected == null) {
        _cacheParentAttemptConnectToApplicationsInspected = new HashSet<>();
        for (var _0 : _reverseoutgoingApplicationConnectionsApplication()) {
          _cacheParentAttemptConnectToApplicationsInspected.add(_0.accessNetworkAndConnections);
        }
        for (var _1 : _reverseoutboundAllowedConnectionsNetwork()) {
          _cacheParentAttemptConnectToApplicationsInspected.add(_1.accessInspected);
        }
        for (var _2 : _reverseoutboundAllowedConnectionsNetwork()) {
          _cacheParentAttemptConnectToApplicationsInspected.add(_2.networkForwardingInspected);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptConnectToApplicationsInspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptConnectToApplicationsInspected");
    }
  }

  public class ConnectToApplicationsUninspected extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenConnectToApplicationsUninspected;

    private Set<AttackStep> _cacheParentConnectToApplicationsUninspected;

    public ConnectToApplicationsUninspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenConnectToApplicationsUninspected == null) {
        _cacheChildrenConnectToApplicationsUninspected = new HashSet<>();
        for (var _0 : _receiverApplicationsConnectionRule()) {
          _cacheChildrenConnectToApplicationsUninspected.add(_0.networkConnectUninspected);
        }
        for (var _1 : _receiverApplicationsConnectionRule()) {
          _cacheChildrenConnectToApplicationsUninspected.add(_1.networkConnectInspected);
        }
      }
      for (AttackStep attackStep : _cacheChildrenConnectToApplicationsUninspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentConnectToApplicationsUninspected == null) {
        _cacheParentConnectToApplicationsUninspected = new HashSet<>();
        _cacheParentConnectToApplicationsUninspected.add(restrictedBypassed);
        _cacheParentConnectToApplicationsUninspected.add(payloadInspectionBypassed);
        _cacheParentConnectToApplicationsUninspected.add(attemptConnectToApplicationsUninspected);
      }
      for (AttackStep attackStep : _cacheParentConnectToApplicationsUninspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.connectToApplicationsUninspected");
    }
  }

  public class ConnectToApplicationsInspected extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenConnectToApplicationsInspected;

    private Set<AttackStep> _cacheParentConnectToApplicationsInspected;

    public ConnectToApplicationsInspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenConnectToApplicationsInspected == null) {
        _cacheChildrenConnectToApplicationsInspected = new HashSet<>();
        for (var _0 : _receiverApplicationsConnectionRule()) {
          _cacheChildrenConnectToApplicationsInspected.add(_0.networkConnectInspected);
        }
      }
      for (AttackStep attackStep : _cacheChildrenConnectToApplicationsInspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentConnectToApplicationsInspected == null) {
        _cacheParentConnectToApplicationsInspected = new HashSet<>();
        _cacheParentConnectToApplicationsInspected.add(restrictedBypassed);
        _cacheParentConnectToApplicationsInspected.add(attemptConnectToApplicationsInspected);
      }
      for (AttackStep attackStep : _cacheParentConnectToApplicationsInspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.connectToApplicationsInspected");
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
        _cacheChildrenAttemptDeny.add(deny);
        _cacheChildrenAttemptDeny.add(bypassRestricted);
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
        for (var _0 : _reverseallNetConnectionsNetwork()) {
          _cacheParentAttemptDeny.add(_0.deny);
        }
        if (routingFirewalls != null) {
          _cacheParentAttemptDeny.add(routingFirewalls.deny);
        }
      }
      for (AttackStep attackStep : _cacheParentAttemptDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.attemptDeny");
    }
  }

  public class Deny extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenDeny;

    private Set<AttackStep> _cacheParentDeny;

    public Deny(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenDeny == null) {
        _cacheChildrenDeny = new HashSet<>();
        for (var _0 : _allApplicationsConnectionRule()) {
          _cacheChildrenDeny.add(_0.denyFromNetworkingAsset);
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
        _cacheParentDeny.add(restrictedBypassed);
        _cacheParentDeny.add(attemptDeny);
      }
      for (AttackStep attackStep : _cacheParentDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("ConnectionRule.deny");
    }
  }
}
