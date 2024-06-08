package com.coevolution.corelang;

import com.coevolution.elements.*;
import java.lang.Boolean;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Network extends Asset {
  public PhysicalAccess physicalAccess;

  public BypassEavesdropDefenseFromPhysicalAccess bypassEavesdropDefenseFromPhysicalAccess;

  public BypassAdversaryInTheMiddleDefenseFromPhysicalAccess bypassAdversaryInTheMiddleDefenseFromPhysicalAccess;

  public NetworkAccessControl networkAccessControl;

  public BypassAccessControl bypassAccessControl;

  public AccessControlBypassed accessControlBypassed;

  public AttemptAccessUninspectedFromPhysicalAccess attemptAccessUninspectedFromPhysicalAccess;

  public AttemptAccessInspectedFromPhysicalAccess attemptAccessInspectedFromPhysicalAccess;

  public SuccessfulAccessUninspectedFromPhysicalAccess successfulAccessUninspectedFromPhysicalAccess;

  public SuccessfulAccessInspectedFromPhysicalAccess successfulAccessInspectedFromPhysicalAccess;

  public AccessUninspected accessUninspected;

  public AccessInspected accessInspected;

  public AttemptReverseReach attemptReverseReach;

  public ReverseReach reverseReach;

  public NetworkForwardingUninspected networkForwardingUninspected;

  public NetworkForwardingInspected networkForwardingInspected;

  public Deny deny;

  public AccessNetworkData accessNetworkData;

  public EavesdropDefense eavesdropDefense;

  public BypassEavesdropDefense bypassEavesdropDefense;

  public EavesdropDefenseBypassed eavesdropDefenseBypassed;

  public AttemptEavesdrop attemptEavesdrop;

  public SuccessfulEavesdrop successfulEavesdrop;

  public Eavesdrop eavesdrop;

  public AdversaryInTheMiddleDefense adversaryInTheMiddleDefense;

  public BypassAdversaryInTheMiddleDefense bypassAdversaryInTheMiddleDefense;

  public AdversaryInTheMiddleDefenseBypassed adversaryInTheMiddleDefenseBypassed;

  public AttemptAdversaryInTheMiddle attemptAdversaryInTheMiddle;

  public SuccessfulAdversaryInTheMiddle successfulAdversaryInTheMiddle;

  public AdversaryInTheMiddle adversaryInTheMiddle;

  private Set<ConnectionRule> _cacheoutboundAllowedConnectionsNetwork;

  private Set<ConnectionRule> _cacheinboundAllowedConnectionsNetwork;

  private Set<ConnectionRule> _cacheallNetConnectionsNetwork;

  private Set<Application> _cacheallowedApplicationConnectionsApplicationsNetwork;

  public Set<PhysicalZone> physicalZones = new HashSet<>();

  public Set<Data> transitData = new HashSet<>();

  public Set<Application> applications = new HashSet<>();

  public Set<ConnectionRule> netConnections = new HashSet<>();

  public Set<ConnectionRule> ingoingNetConnections = new HashSet<>();

  public Set<ConnectionRule> outgoingNetConnections = new HashSet<>();

  public Set<ConnectionRule> diodeIngoingNetConnections = new HashSet<>();

  public Network(String name, boolean isNetworkAccessControlEnabled,
      boolean isEavesdropDefenseEnabled, boolean isAdversaryInTheMiddleDefenseEnabled) {
    super(name);
    assetClassName = "Network";
    AttackStep.allAttackSteps.remove(physicalAccess);
    physicalAccess = new PhysicalAccess(name);
    AttackStep.allAttackSteps.remove(bypassEavesdropDefenseFromPhysicalAccess);
    bypassEavesdropDefenseFromPhysicalAccess = new BypassEavesdropDefenseFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(bypassAdversaryInTheMiddleDefenseFromPhysicalAccess);
    bypassAdversaryInTheMiddleDefenseFromPhysicalAccess = new BypassAdversaryInTheMiddleDefenseFromPhysicalAccess(name);
    if (networkAccessControl != null) {
      AttackStep.allAttackSteps.remove(networkAccessControl.disable);
    }
    Defense.allDefenses.remove(networkAccessControl);
    networkAccessControl = new NetworkAccessControl(name, isNetworkAccessControlEnabled);
    AttackStep.allAttackSteps.remove(bypassAccessControl);
    bypassAccessControl = new BypassAccessControl(name);
    AttackStep.allAttackSteps.remove(accessControlBypassed);
    accessControlBypassed = new AccessControlBypassed(name);
    AttackStep.allAttackSteps.remove(attemptAccessUninspectedFromPhysicalAccess);
    attemptAccessUninspectedFromPhysicalAccess = new AttemptAccessUninspectedFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(attemptAccessInspectedFromPhysicalAccess);
    attemptAccessInspectedFromPhysicalAccess = new AttemptAccessInspectedFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(successfulAccessUninspectedFromPhysicalAccess);
    successfulAccessUninspectedFromPhysicalAccess = new SuccessfulAccessUninspectedFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(successfulAccessInspectedFromPhysicalAccess);
    successfulAccessInspectedFromPhysicalAccess = new SuccessfulAccessInspectedFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(accessUninspected);
    accessUninspected = new AccessUninspected(name);
    AttackStep.allAttackSteps.remove(accessInspected);
    accessInspected = new AccessInspected(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(networkForwardingUninspected);
    networkForwardingUninspected = new NetworkForwardingUninspected(name);
    AttackStep.allAttackSteps.remove(networkForwardingInspected);
    networkForwardingInspected = new NetworkForwardingInspected(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(accessNetworkData);
    accessNetworkData = new AccessNetworkData(name);
    if (eavesdropDefense != null) {
      AttackStep.allAttackSteps.remove(eavesdropDefense.disable);
    }
    Defense.allDefenses.remove(eavesdropDefense);
    eavesdropDefense = new EavesdropDefense(name, isEavesdropDefenseEnabled);
    AttackStep.allAttackSteps.remove(bypassEavesdropDefense);
    bypassEavesdropDefense = new BypassEavesdropDefense(name);
    AttackStep.allAttackSteps.remove(eavesdropDefenseBypassed);
    eavesdropDefenseBypassed = new EavesdropDefenseBypassed(name);
    AttackStep.allAttackSteps.remove(attemptEavesdrop);
    attemptEavesdrop = new AttemptEavesdrop(name);
    AttackStep.allAttackSteps.remove(successfulEavesdrop);
    successfulEavesdrop = new SuccessfulEavesdrop(name);
    AttackStep.allAttackSteps.remove(eavesdrop);
    eavesdrop = new Eavesdrop(name);
    if (adversaryInTheMiddleDefense != null) {
      AttackStep.allAttackSteps.remove(adversaryInTheMiddleDefense.disable);
    }
    Defense.allDefenses.remove(adversaryInTheMiddleDefense);
    adversaryInTheMiddleDefense = new AdversaryInTheMiddleDefense(name, isAdversaryInTheMiddleDefenseEnabled);
    AttackStep.allAttackSteps.remove(bypassAdversaryInTheMiddleDefense);
    bypassAdversaryInTheMiddleDefense = new BypassAdversaryInTheMiddleDefense(name);
    AttackStep.allAttackSteps.remove(adversaryInTheMiddleDefenseBypassed);
    adversaryInTheMiddleDefenseBypassed = new AdversaryInTheMiddleDefenseBypassed(name);
    AttackStep.allAttackSteps.remove(attemptAdversaryInTheMiddle);
    attemptAdversaryInTheMiddle = new AttemptAdversaryInTheMiddle(name);
    AttackStep.allAttackSteps.remove(successfulAdversaryInTheMiddle);
    successfulAdversaryInTheMiddle = new SuccessfulAdversaryInTheMiddle(name);
    AttackStep.allAttackSteps.remove(adversaryInTheMiddle);
    adversaryInTheMiddle = new AdversaryInTheMiddle(name);
  }

  public Network(String name) {
    super(name);
    assetClassName = "Network";
    AttackStep.allAttackSteps.remove(physicalAccess);
    physicalAccess = new PhysicalAccess(name);
    AttackStep.allAttackSteps.remove(bypassEavesdropDefenseFromPhysicalAccess);
    bypassEavesdropDefenseFromPhysicalAccess = new BypassEavesdropDefenseFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(bypassAdversaryInTheMiddleDefenseFromPhysicalAccess);
    bypassAdversaryInTheMiddleDefenseFromPhysicalAccess = new BypassAdversaryInTheMiddleDefenseFromPhysicalAccess(name);
    if (networkAccessControl != null) {
      AttackStep.allAttackSteps.remove(networkAccessControl.disable);
    }
    Defense.allDefenses.remove(networkAccessControl);
    networkAccessControl = new NetworkAccessControl(name, false);
    AttackStep.allAttackSteps.remove(bypassAccessControl);
    bypassAccessControl = new BypassAccessControl(name);
    AttackStep.allAttackSteps.remove(accessControlBypassed);
    accessControlBypassed = new AccessControlBypassed(name);
    AttackStep.allAttackSteps.remove(attemptAccessUninspectedFromPhysicalAccess);
    attemptAccessUninspectedFromPhysicalAccess = new AttemptAccessUninspectedFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(attemptAccessInspectedFromPhysicalAccess);
    attemptAccessInspectedFromPhysicalAccess = new AttemptAccessInspectedFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(successfulAccessUninspectedFromPhysicalAccess);
    successfulAccessUninspectedFromPhysicalAccess = new SuccessfulAccessUninspectedFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(successfulAccessInspectedFromPhysicalAccess);
    successfulAccessInspectedFromPhysicalAccess = new SuccessfulAccessInspectedFromPhysicalAccess(name);
    AttackStep.allAttackSteps.remove(accessUninspected);
    accessUninspected = new AccessUninspected(name);
    AttackStep.allAttackSteps.remove(accessInspected);
    accessInspected = new AccessInspected(name);
    AttackStep.allAttackSteps.remove(attemptReverseReach);
    attemptReverseReach = new AttemptReverseReach(name);
    AttackStep.allAttackSteps.remove(reverseReach);
    reverseReach = new ReverseReach(name);
    AttackStep.allAttackSteps.remove(networkForwardingUninspected);
    networkForwardingUninspected = new NetworkForwardingUninspected(name);
    AttackStep.allAttackSteps.remove(networkForwardingInspected);
    networkForwardingInspected = new NetworkForwardingInspected(name);
    AttackStep.allAttackSteps.remove(deny);
    deny = new Deny(name);
    AttackStep.allAttackSteps.remove(accessNetworkData);
    accessNetworkData = new AccessNetworkData(name);
    if (eavesdropDefense != null) {
      AttackStep.allAttackSteps.remove(eavesdropDefense.disable);
    }
    Defense.allDefenses.remove(eavesdropDefense);
    eavesdropDefense = new EavesdropDefense(name, false);
    AttackStep.allAttackSteps.remove(bypassEavesdropDefense);
    bypassEavesdropDefense = new BypassEavesdropDefense(name);
    AttackStep.allAttackSteps.remove(eavesdropDefenseBypassed);
    eavesdropDefenseBypassed = new EavesdropDefenseBypassed(name);
    AttackStep.allAttackSteps.remove(attemptEavesdrop);
    attemptEavesdrop = new AttemptEavesdrop(name);
    AttackStep.allAttackSteps.remove(successfulEavesdrop);
    successfulEavesdrop = new SuccessfulEavesdrop(name);
    AttackStep.allAttackSteps.remove(eavesdrop);
    eavesdrop = new Eavesdrop(name);
    if (adversaryInTheMiddleDefense != null) {
      AttackStep.allAttackSteps.remove(adversaryInTheMiddleDefense.disable);
    }
    Defense.allDefenses.remove(adversaryInTheMiddleDefense);
    adversaryInTheMiddleDefense = new AdversaryInTheMiddleDefense(name, false);
    AttackStep.allAttackSteps.remove(bypassAdversaryInTheMiddleDefense);
    bypassAdversaryInTheMiddleDefense = new BypassAdversaryInTheMiddleDefense(name);
    AttackStep.allAttackSteps.remove(adversaryInTheMiddleDefenseBypassed);
    adversaryInTheMiddleDefenseBypassed = new AdversaryInTheMiddleDefenseBypassed(name);
    AttackStep.allAttackSteps.remove(attemptAdversaryInTheMiddle);
    attemptAdversaryInTheMiddle = new AttemptAdversaryInTheMiddle(name);
    AttackStep.allAttackSteps.remove(successfulAdversaryInTheMiddle);
    successfulAdversaryInTheMiddle = new SuccessfulAdversaryInTheMiddle(name);
    AttackStep.allAttackSteps.remove(adversaryInTheMiddle);
    adversaryInTheMiddle = new AdversaryInTheMiddle(name);
  }

  public Network(boolean isNetworkAccessControlEnabled, boolean isEavesdropDefenseEnabled,
      boolean isAdversaryInTheMiddleDefenseEnabled) {
    this("Anonymous", isNetworkAccessControlEnabled, isEavesdropDefenseEnabled, isAdversaryInTheMiddleDefenseEnabled);
  }

  public Network() {
    this("Anonymous");
  }

  protected Set<ConnectionRule> _outboundAllowedConnectionsNetwork() {
    if (_cacheoutboundAllowedConnectionsNetwork == null) {
      _cacheoutboundAllowedConnectionsNetwork = new HashSet<>();
      Set<ConnectionRule> _2 = new HashSet<>();
      Set<ConnectionRule> _3 = new HashSet<>();
      for (ConnectionRule _4 : netConnections) {
        _2.add(_4);
      }
      for (ConnectionRule _5 : outgoingNetConnections) {
        _3.add(_5);
      }
      _2.addAll(_3);
      for (ConnectionRule _6 : _2) {
        _cacheoutboundAllowedConnectionsNetwork.add(_6);
      }
    }
    return _cacheoutboundAllowedConnectionsNetwork;
  }

  protected Set<ConnectionRule> _inboundAllowedConnectionsNetwork() {
    if (_cacheinboundAllowedConnectionsNetwork == null) {
      _cacheinboundAllowedConnectionsNetwork = new HashSet<>();
      Set<ConnectionRule> _7 = new HashSet<>();
      Set<ConnectionRule> _8 = new HashSet<>();
      Set<ConnectionRule> _9 = new HashSet<>();
      Set<ConnectionRule> _a = new HashSet<>();
      for (ConnectionRule _b : netConnections) {
        _9.add(_b);
      }
      for (ConnectionRule _c : ingoingNetConnections) {
        _a.add(_c);
      }
      _9.addAll(_a);
      for (ConnectionRule _d : _9) {
        _7.add(_d);
      }
      for (ConnectionRule _e : diodeIngoingNetConnections) {
        _8.add(_e);
      }
      _7.addAll(_8);
      for (ConnectionRule _f : _7) {
        _cacheinboundAllowedConnectionsNetwork.add(_f);
      }
    }
    return _cacheinboundAllowedConnectionsNetwork;
  }

  protected Set<ConnectionRule> _allNetConnectionsNetwork() {
    if (_cacheallNetConnectionsNetwork == null) {
      _cacheallNetConnectionsNetwork = new HashSet<>();
      Set<ConnectionRule> _10 = new HashSet<>();
      Set<ConnectionRule> _11 = new HashSet<>();
      Set<ConnectionRule> _12 = new HashSet<>();
      Set<ConnectionRule> _13 = new HashSet<>();
      Set<ConnectionRule> _14 = new HashSet<>();
      Set<ConnectionRule> _15 = new HashSet<>();
      for (ConnectionRule _16 : netConnections) {
        _14.add(_16);
      }
      for (ConnectionRule _17 : ingoingNetConnections) {
        _15.add(_17);
      }
      _14.addAll(_15);
      for (ConnectionRule _18 : _14) {
        _12.add(_18);
      }
      for (ConnectionRule _19 : outgoingNetConnections) {
        _13.add(_19);
      }
      _12.addAll(_13);
      for (ConnectionRule _1a : _12) {
        _10.add(_1a);
      }
      for (ConnectionRule _1b : diodeIngoingNetConnections) {
        _11.add(_1b);
      }
      _10.addAll(_11);
      for (ConnectionRule _1c : _10) {
        _cacheallNetConnectionsNetwork.add(_1c);
      }
    }
    return _cacheallNetConnectionsNetwork;
  }

  protected Set<Application> _allowedApplicationConnectionsApplicationsNetwork() {
    if (_cacheallowedApplicationConnectionsApplicationsNetwork == null) {
      _cacheallowedApplicationConnectionsApplicationsNetwork = new HashSet<>();
      Set<Application> _1d = new HashSet<>();
      Set<Application> _1e = new HashSet<>();
      for (Application _1f : applications) {
        _1d.add(_1f);
      }
      for (var _20 : _allNetConnectionsNetwork()) {
        for (Application _21 : _20.applications) {
          _1e.add(_21);
        }
      }
      _1d.addAll(_1e);
      for (Application _22 : _1d) {
        _cacheallowedApplicationConnectionsApplicationsNetwork.add(_22);
      }
    }
    return _cacheallowedApplicationConnectionsApplicationsNetwork;
  }

  public void addPhysicalZones(PhysicalZone physicalZones) {
    this.physicalZones.add(physicalZones);
    physicalZones.networks.add(this);
  }

  public void addTransitData(Data transitData) {
    this.transitData.add(transitData);
    transitData.transitNetwork.add(this);
  }

  public void addApplications(Application applications) {
    this.applications.add(applications);
    applications.networks.add(this);
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

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("physicalZones")) {
      return PhysicalZone.class.getName();
    } else if (field.equals("transitData")) {
      return Data.class.getName();
    } else if (field.equals("applications")) {
      return Application.class.getName();
    } else if (field.equals("netConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("ingoingNetConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("outgoingNetConnections")) {
      return ConnectionRule.class.getName();
    } else if (field.equals("diodeIngoingNetConnections")) {
      return ConnectionRule.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("physicalZones")) {
      assets.addAll(physicalZones);
    } else if (field.equals("transitData")) {
      assets.addAll(transitData);
    } else if (field.equals("applications")) {
      assets.addAll(applications);
    } else if (field.equals("netConnections")) {
      assets.addAll(netConnections);
    } else if (field.equals("ingoingNetConnections")) {
      assets.addAll(ingoingNetConnections);
    } else if (field.equals("outgoingNetConnections")) {
      assets.addAll(outgoingNetConnections);
    } else if (field.equals("diodeIngoingNetConnections")) {
      assets.addAll(diodeIngoingNetConnections);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(physicalZones);
    assets.addAll(transitData);
    assets.addAll(applications);
    assets.addAll(netConnections);
    assets.addAll(ingoingNetConnections);
    assets.addAll(outgoingNetConnections);
    assets.addAll(diodeIngoingNetConnections);
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
        _cacheChildrenPhysicalAccess.add(deny);
        _cacheChildrenPhysicalAccess.add(attemptAccessUninspectedFromPhysicalAccess);
        _cacheChildrenPhysicalAccess.add(attemptAccessInspectedFromPhysicalAccess);
        _cacheChildrenPhysicalAccess.add(bypassEavesdropDefenseFromPhysicalAccess);
        _cacheChildrenPhysicalAccess.add(bypassAdversaryInTheMiddleDefenseFromPhysicalAccess);
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

  public class BypassEavesdropDefenseFromPhysicalAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassEavesdropDefenseFromPhysicalAccess;

    private Set<AttackStep> _cacheParentBypassEavesdropDefenseFromPhysicalAccess;

    public BypassEavesdropDefenseFromPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassEavesdropDefenseFromPhysicalAccess == null) {
        _cacheChildrenBypassEavesdropDefenseFromPhysicalAccess = new HashSet<>();
        _cacheChildrenBypassEavesdropDefenseFromPhysicalAccess.add(eavesdropDefenseBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassEavesdropDefenseFromPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassEavesdropDefenseFromPhysicalAccess == null) {
        _cacheParentBypassEavesdropDefenseFromPhysicalAccess = new HashSet<>();
        _cacheParentBypassEavesdropDefenseFromPhysicalAccess.add(physicalAccess);
      }
      for (AttackStep attackStep : _cacheParentBypassEavesdropDefenseFromPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassEavesdropDefenseFromPhysicalAccess");
    }
  }

  public class BypassAdversaryInTheMiddleDefenseFromPhysicalAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassAdversaryInTheMiddleDefenseFromPhysicalAccess;

    private Set<AttackStep> _cacheParentBypassAdversaryInTheMiddleDefenseFromPhysicalAccess;

    public BypassAdversaryInTheMiddleDefenseFromPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassAdversaryInTheMiddleDefenseFromPhysicalAccess == null) {
        _cacheChildrenBypassAdversaryInTheMiddleDefenseFromPhysicalAccess = new HashSet<>();
        _cacheChildrenBypassAdversaryInTheMiddleDefenseFromPhysicalAccess.add(adversaryInTheMiddleDefenseBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassAdversaryInTheMiddleDefenseFromPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassAdversaryInTheMiddleDefenseFromPhysicalAccess == null) {
        _cacheParentBypassAdversaryInTheMiddleDefenseFromPhysicalAccess = new HashSet<>();
        _cacheParentBypassAdversaryInTheMiddleDefenseFromPhysicalAccess.add(physicalAccess);
      }
      for (AttackStep attackStep : _cacheParentBypassAdversaryInTheMiddleDefenseFromPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassAdversaryInTheMiddleDefenseFromPhysicalAccess");
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
          _cacheChildrenNetworkAccessControl.add(accessControlBypassed);
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
        _cacheChildrenBypassAccessControl.add(accessControlBypassed);
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
        _cacheParentBypassAccessControl.add(attemptAccessUninspectedFromPhysicalAccess);
        _cacheParentBypassAccessControl.add(attemptAccessInspectedFromPhysicalAccess);
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

  public class AccessControlBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessControlBypassed;

    private Set<AttackStep> _cacheParentAccessControlBypassed;

    public AccessControlBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessControlBypassed == null) {
        _cacheChildrenAccessControlBypassed = new HashSet<>();
        _cacheChildrenAccessControlBypassed.add(successfulAccessUninspectedFromPhysicalAccess);
        _cacheChildrenAccessControlBypassed.add(successfulAccessInspectedFromPhysicalAccess);
      }
      for (AttackStep attackStep : _cacheChildrenAccessControlBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessControlBypassed == null) {
        _cacheParentAccessControlBypassed = new HashSet<>();
        _cacheParentAccessControlBypassed.add(networkAccessControl.disable);
        _cacheParentAccessControlBypassed.add(bypassAccessControl);
      }
      for (AttackStep attackStep : _cacheParentAccessControlBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.accessControlBypassed");
    }
  }

  public class AttemptAccessUninspectedFromPhysicalAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAccessUninspectedFromPhysicalAccess;

    private Set<AttackStep> _cacheParentAttemptAccessUninspectedFromPhysicalAccess;

    public AttemptAccessUninspectedFromPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccessUninspectedFromPhysicalAccess == null) {
        _cacheChildrenAttemptAccessUninspectedFromPhysicalAccess = new HashSet<>();
        _cacheChildrenAttemptAccessUninspectedFromPhysicalAccess.add(successfulAccessUninspectedFromPhysicalAccess);
        _cacheChildrenAttemptAccessUninspectedFromPhysicalAccess.add(bypassAccessControl);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccessUninspectedFromPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccessUninspectedFromPhysicalAccess == null) {
        _cacheParentAttemptAccessUninspectedFromPhysicalAccess = new HashSet<>();
        _cacheParentAttemptAccessUninspectedFromPhysicalAccess.add(physicalAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptAccessUninspectedFromPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.attemptAccessUninspectedFromPhysicalAccess");
    }
  }

  public class AttemptAccessInspectedFromPhysicalAccess extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAccessInspectedFromPhysicalAccess;

    private Set<AttackStep> _cacheParentAttemptAccessInspectedFromPhysicalAccess;

    public AttemptAccessInspectedFromPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAccessInspectedFromPhysicalAccess == null) {
        _cacheChildrenAttemptAccessInspectedFromPhysicalAccess = new HashSet<>();
        _cacheChildrenAttemptAccessInspectedFromPhysicalAccess.add(successfulAccessInspectedFromPhysicalAccess);
        _cacheChildrenAttemptAccessInspectedFromPhysicalAccess.add(bypassAccessControl);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAccessInspectedFromPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAccessInspectedFromPhysicalAccess == null) {
        _cacheParentAttemptAccessInspectedFromPhysicalAccess = new HashSet<>();
        _cacheParentAttemptAccessInspectedFromPhysicalAccess.add(physicalAccess);
      }
      for (AttackStep attackStep : _cacheParentAttemptAccessInspectedFromPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.attemptAccessInspectedFromPhysicalAccess");
    }
  }

  public class SuccessfulAccessUninspectedFromPhysicalAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulAccessUninspectedFromPhysicalAccess;

    private Set<AttackStep> _cacheParentSuccessfulAccessUninspectedFromPhysicalAccess;

    public SuccessfulAccessUninspectedFromPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAccessUninspectedFromPhysicalAccess == null) {
        _cacheChildrenSuccessfulAccessUninspectedFromPhysicalAccess = new HashSet<>();
        _cacheChildrenSuccessfulAccessUninspectedFromPhysicalAccess.add(accessUninspected);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAccessUninspectedFromPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulAccessUninspectedFromPhysicalAccess == null) {
        _cacheParentSuccessfulAccessUninspectedFromPhysicalAccess = new HashSet<>();
        _cacheParentSuccessfulAccessUninspectedFromPhysicalAccess.add(accessControlBypassed);
        _cacheParentSuccessfulAccessUninspectedFromPhysicalAccess.add(attemptAccessUninspectedFromPhysicalAccess);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAccessUninspectedFromPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.successfulAccessUninspectedFromPhysicalAccess");
    }
  }

  public class SuccessfulAccessInspectedFromPhysicalAccess extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulAccessInspectedFromPhysicalAccess;

    private Set<AttackStep> _cacheParentSuccessfulAccessInspectedFromPhysicalAccess;

    public SuccessfulAccessInspectedFromPhysicalAccess(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAccessInspectedFromPhysicalAccess == null) {
        _cacheChildrenSuccessfulAccessInspectedFromPhysicalAccess = new HashSet<>();
        _cacheChildrenSuccessfulAccessInspectedFromPhysicalAccess.add(accessInspected);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAccessInspectedFromPhysicalAccess) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulAccessInspectedFromPhysicalAccess == null) {
        _cacheParentSuccessfulAccessInspectedFromPhysicalAccess = new HashSet<>();
        _cacheParentSuccessfulAccessInspectedFromPhysicalAccess.add(accessControlBypassed);
        _cacheParentSuccessfulAccessInspectedFromPhysicalAccess.add(attemptAccessInspectedFromPhysicalAccess);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAccessInspectedFromPhysicalAccess) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.successfulAccessInspectedFromPhysicalAccess");
    }
  }

  public class AccessUninspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessUninspected;

    private Set<AttackStep> _cacheParentAccessUninspected;

    public AccessUninspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessUninspected == null) {
        _cacheChildrenAccessUninspected = new HashSet<>();
        for (var _0 : _outboundAllowedConnectionsNetwork()) {
          _cacheChildrenAccessUninspected.add(_0.attemptConnectToApplicationsUninspected);
        }
        for (Application _1 : applications) {
          _cacheChildrenAccessUninspected.add(_1.networkConnectUninspected);
        }
        _cacheChildrenAccessUninspected.add(networkForwardingUninspected);
        _cacheChildrenAccessUninspected.add(attemptReverseReach);
        _cacheChildrenAccessUninspected.add(accessNetworkData);
        _cacheChildrenAccessUninspected.add(deny);
      }
      for (AttackStep attackStep : _cacheChildrenAccessUninspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessUninspected == null) {
        _cacheParentAccessUninspected = new HashSet<>();
        for (Application _2 : applications) {
          _cacheParentAccessUninspected.add(_2.accessNetworkAndConnections);
        }
        _cacheParentAccessUninspected.add(successfulAccessUninspectedFromPhysicalAccess);
        Set<RoutingFirewall> _3 = new HashSet<>();
        Set<RoutingFirewall> _4 = new HashSet<>();
        for (ConnectionRule _5 : diodeIngoingNetConnections) {
          if (_5.routingFirewalls != null) {
            _3.add(_5.routingFirewalls);
          }
        }
        Set<RoutingFirewall> _6 = new HashSet<>();
        Set<RoutingFirewall> _7 = new HashSet<>();
        for (ConnectionRule _8 : ingoingNetConnections) {
          if (_8.routingFirewalls != null) {
            _6.add(_8.routingFirewalls);
          }
        }
        Set<RoutingFirewall> _9 = new HashSet<>();
        Set<RoutingFirewall> _a = new HashSet<>();
        for (ConnectionRule _b : outgoingNetConnections) {
          if (_b.routingFirewalls != null) {
            _9.add(_b.routingFirewalls);
          }
        }
        for (ConnectionRule _c : netConnections) {
          if (_c.routingFirewalls != null) {
            _a.add(_c.routingFirewalls);
          }
        }
        _9.addAll(_a);
        for (RoutingFirewall _d : _9) {
          _7.add(_d);
        }
        _6.addAll(_7);
        for (RoutingFirewall _e : _6) {
          _4.add(_e);
        }
        _3.addAll(_4);
        for (RoutingFirewall _f : _3) {
          _cacheParentAccessUninspected.add(_f.fullAccess);
        }
        Set<ConnectionRule> _10 = new HashSet<>();
        Set<ConnectionRule> _11 = new HashSet<>();
        for (ConnectionRule _12 : diodeIngoingNetConnections) {
          _10.add(_12);
        }
        Set<ConnectionRule> _13 = new HashSet<>();
        Set<ConnectionRule> _14 = new HashSet<>();
        for (ConnectionRule _15 : ingoingNetConnections) {
          _13.add(_15);
        }
        for (ConnectionRule _16 : netConnections) {
          _14.add(_16);
        }
        _13.addAll(_14);
        for (ConnectionRule _17 : _13) {
          _11.add(_17);
        }
        _10.addAll(_11);
        for (ConnectionRule _18 : _10) {
          _cacheParentAccessUninspected.add(_18.accessNetworksUninspected);
        }
      }
      for (AttackStep attackStep : _cacheParentAccessUninspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.accessUninspected");
    }
  }

  public class AccessInspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAccessInspected;

    private Set<AttackStep> _cacheParentAccessInspected;

    public AccessInspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAccessInspected == null) {
        _cacheChildrenAccessInspected = new HashSet<>();
        for (var _0 : _outboundAllowedConnectionsNetwork()) {
          _cacheChildrenAccessInspected.add(_0.attemptConnectToApplicationsInspected);
        }
        for (Application _1 : applications) {
          _cacheChildrenAccessInspected.add(_1.networkConnectInspected);
        }
        _cacheChildrenAccessInspected.add(networkForwardingInspected);
        _cacheChildrenAccessInspected.add(accessNetworkData);
        _cacheChildrenAccessInspected.add(deny);
      }
      for (AttackStep attackStep : _cacheChildrenAccessInspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAccessInspected == null) {
        _cacheParentAccessInspected = new HashSet<>();
        for (Application _2 : applications) {
          _cacheParentAccessInspected.add(_2.accessNetworkAndConnections);
        }
        _cacheParentAccessInspected.add(successfulAccessInspectedFromPhysicalAccess);
        Set<ConnectionRule> _3 = new HashSet<>();
        Set<ConnectionRule> _4 = new HashSet<>();
        for (ConnectionRule _5 : diodeIngoingNetConnections) {
          _3.add(_5);
        }
        Set<ConnectionRule> _6 = new HashSet<>();
        Set<ConnectionRule> _7 = new HashSet<>();
        for (ConnectionRule _8 : ingoingNetConnections) {
          _6.add(_8);
        }
        for (ConnectionRule _9 : netConnections) {
          _7.add(_9);
        }
        _6.addAll(_7);
        for (ConnectionRule _a : _6) {
          _4.add(_a);
        }
        _3.addAll(_4);
        for (ConnectionRule _b : _3) {
          _cacheParentAccessInspected.add(_b.accessNetworksInspected);
        }
      }
      for (AttackStep attackStep : _cacheParentAccessInspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.accessInspected");
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
        _cacheParentAttemptReverseReach.add(accessUninspected);
        Set<ConnectionRule> _1 = new HashSet<>();
        Set<ConnectionRule> _2 = new HashSet<>();
        for (ConnectionRule _3 : outgoingNetConnections) {
          _1.add(_3);
        }
        for (ConnectionRule _4 : netConnections) {
          _2.add(_4);
        }
        _1.addAll(_2);
        for (ConnectionRule _5 : _1) {
          _cacheParentAttemptReverseReach.add(_5.reverseReach);
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
        for (var _0 : _inboundAllowedConnectionsNetwork()) {
          _cacheChildrenReverseReach.add(_0.attemptReverseReach);
        }
        for (Application _1 : applications) {
          _cacheChildrenReverseReach.add(_1.attemptReverseReach);
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

  public class NetworkForwardingUninspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkForwardingUninspected;

    private Set<AttackStep> _cacheParentNetworkForwardingUninspected;

    public NetworkForwardingUninspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkForwardingUninspected == null) {
        _cacheChildrenNetworkForwardingUninspected = new HashSet<>();
        for (var _0 : _outboundAllowedConnectionsNetwork()) {
          _cacheChildrenNetworkForwardingUninspected.add(_0.attemptAccessNetworksUninspected);
        }
        for (var _1 : _outboundAllowedConnectionsNetwork()) {
          _cacheChildrenNetworkForwardingUninspected.add(_1.attemptConnectToApplicationsUninspected);
        }
        _cacheChildrenNetworkForwardingUninspected.add(networkForwardingInspected);
      }
      for (AttackStep attackStep : _cacheChildrenNetworkForwardingUninspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkForwardingUninspected == null) {
        _cacheParentNetworkForwardingUninspected = new HashSet<>();
        _cacheParentNetworkForwardingUninspected.add(accessUninspected);
      }
      for (AttackStep attackStep : _cacheParentNetworkForwardingUninspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.networkForwardingUninspected");
    }
  }

  public class NetworkForwardingInspected extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenNetworkForwardingInspected;

    private Set<AttackStep> _cacheParentNetworkForwardingInspected;

    public NetworkForwardingInspected(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenNetworkForwardingInspected == null) {
        _cacheChildrenNetworkForwardingInspected = new HashSet<>();
        for (var _0 : _outboundAllowedConnectionsNetwork()) {
          _cacheChildrenNetworkForwardingInspected.add(_0.attemptAccessNetworksInspected);
        }
        for (var _1 : _outboundAllowedConnectionsNetwork()) {
          _cacheChildrenNetworkForwardingInspected.add(_1.attemptConnectToApplicationsInspected);
        }
      }
      for (AttackStep attackStep : _cacheChildrenNetworkForwardingInspected) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentNetworkForwardingInspected == null) {
        _cacheParentNetworkForwardingInspected = new HashSet<>();
        _cacheParentNetworkForwardingInspected.add(accessInspected);
        _cacheParentNetworkForwardingInspected.add(networkForwardingUninspected);
      }
      for (AttackStep attackStep : _cacheParentNetworkForwardingInspected) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.networkForwardingInspected");
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
        for (var _0 : _allNetConnectionsNetwork()) {
          _cacheChildrenDeny.add(_0.attemptDeny);
        }
        for (var _1 : _allowedApplicationConnectionsApplicationsNetwork()) {
          _cacheChildrenDeny.add(_1.denyFromNetworkingAsset);
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
        _cacheParentDeny.add(physicalAccess);
        _cacheParentDeny.add(accessUninspected);
        _cacheParentDeny.add(accessInspected);
      }
      for (AttackStep attackStep : _cacheParentDeny) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.deny");
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
        _cacheChildrenAccessNetworkData.add(attemptEavesdrop);
        _cacheChildrenAccessNetworkData.add(attemptAdversaryInTheMiddle);
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
        _cacheParentAccessNetworkData.add(accessUninspected);
        _cacheParentAccessNetworkData.add(accessInspected);
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
          _cacheChildrenEavesdropDefense.add(eavesdropDefenseBypassed);
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

  public class BypassEavesdropDefense extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassEavesdropDefense;

    private Set<AttackStep> _cacheParentBypassEavesdropDefense;

    public BypassEavesdropDefense(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassEavesdropDefense == null) {
        _cacheChildrenBypassEavesdropDefense = new HashSet<>();
        _cacheChildrenBypassEavesdropDefense.add(eavesdropDefenseBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassEavesdropDefense) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassEavesdropDefense == null) {
        _cacheParentBypassEavesdropDefense = new HashSet<>();
        _cacheParentBypassEavesdropDefense.add(attemptEavesdrop);
      }
      for (AttackStep attackStep : _cacheParentBypassEavesdropDefense) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassEavesdropDefense");
    }
  }

  public class EavesdropDefenseBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenEavesdropDefenseBypassed;

    private Set<AttackStep> _cacheParentEavesdropDefenseBypassed;

    public EavesdropDefenseBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenEavesdropDefenseBypassed == null) {
        _cacheChildrenEavesdropDefenseBypassed = new HashSet<>();
        _cacheChildrenEavesdropDefenseBypassed.add(successfulEavesdrop);
      }
      for (AttackStep attackStep : _cacheChildrenEavesdropDefenseBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentEavesdropDefenseBypassed == null) {
        _cacheParentEavesdropDefenseBypassed = new HashSet<>();
        _cacheParentEavesdropDefenseBypassed.add(bypassEavesdropDefenseFromPhysicalAccess);
        _cacheParentEavesdropDefenseBypassed.add(eavesdropDefense.disable);
        _cacheParentEavesdropDefenseBypassed.add(bypassEavesdropDefense);
      }
      for (AttackStep attackStep : _cacheParentEavesdropDefenseBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.eavesdropDefenseBypassed");
    }
  }

  public class AttemptEavesdrop extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptEavesdrop;

    private Set<AttackStep> _cacheParentAttemptEavesdrop;

    public AttemptEavesdrop(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptEavesdrop == null) {
        _cacheChildrenAttemptEavesdrop = new HashSet<>();
        _cacheChildrenAttemptEavesdrop.add(successfulEavesdrop);
        _cacheChildrenAttemptEavesdrop.add(bypassEavesdropDefense);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptEavesdrop) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptEavesdrop == null) {
        _cacheParentAttemptEavesdrop = new HashSet<>();
        _cacheParentAttemptEavesdrop.add(accessNetworkData);
      }
      for (AttackStep attackStep : _cacheParentAttemptEavesdrop) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.attemptEavesdrop");
    }
  }

  public class SuccessfulEavesdrop extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulEavesdrop;

    private Set<AttackStep> _cacheParentSuccessfulEavesdrop;

    public SuccessfulEavesdrop(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulEavesdrop == null) {
        _cacheChildrenSuccessfulEavesdrop = new HashSet<>();
        _cacheChildrenSuccessfulEavesdrop.add(eavesdrop);
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
        _cacheParentSuccessfulEavesdrop.add(eavesdropDefenseBypassed);
        _cacheParentSuccessfulEavesdrop.add(attemptEavesdrop);
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

  public class Eavesdrop extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenEavesdrop;

    private Set<AttackStep> _cacheParentEavesdrop;

    public Eavesdrop(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenEavesdrop == null) {
        _cacheChildrenEavesdrop = new HashSet<>();
        for (Data _0 : transitData) {
          _cacheChildrenEavesdrop.add(_0.attemptRead);
        }
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
        _cacheParentEavesdrop.add(successfulEavesdrop);
        _cacheParentEavesdrop.add(adversaryInTheMiddle);
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

  public class AdversaryInTheMiddleDefense extends Defense {
    public AdversaryInTheMiddleDefense(String name) {
      this(name, false);
    }

    public AdversaryInTheMiddleDefense(String name, Boolean isEnabled) {
      super(name);
      defaultValue = isEnabled;
      disable = new Disable(name);
    }

    public class Disable extends AttackStepMin {
      private Set<AttackStep> _cacheChildrenAdversaryInTheMiddleDefense;

      public Disable(String name) {
        super(name);
      }

      @Override
      public void updateChildren(Set<AttackStep> attackSteps) {
        if (_cacheChildrenAdversaryInTheMiddleDefense == null) {
          _cacheChildrenAdversaryInTheMiddleDefense = new HashSet<>();
          _cacheChildrenAdversaryInTheMiddleDefense.add(adversaryInTheMiddleDefenseBypassed);
        }
        for (AttackStep attackStep : _cacheChildrenAdversaryInTheMiddleDefense) {
          attackStep.updateTtc(this, ttc, attackSteps);
        }
      }

      @Override
      public String fullName() {
        return "Network.adversaryInTheMiddleDefense";
      }
    }
  }

  public class BypassAdversaryInTheMiddleDefense extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenBypassAdversaryInTheMiddleDefense;

    private Set<AttackStep> _cacheParentBypassAdversaryInTheMiddleDefense;

    public BypassAdversaryInTheMiddleDefense(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenBypassAdversaryInTheMiddleDefense == null) {
        _cacheChildrenBypassAdversaryInTheMiddleDefense = new HashSet<>();
        _cacheChildrenBypassAdversaryInTheMiddleDefense.add(adversaryInTheMiddleDefenseBypassed);
      }
      for (AttackStep attackStep : _cacheChildrenBypassAdversaryInTheMiddleDefense) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentBypassAdversaryInTheMiddleDefense == null) {
        _cacheParentBypassAdversaryInTheMiddleDefense = new HashSet<>();
        _cacheParentBypassAdversaryInTheMiddleDefense.add(attemptAdversaryInTheMiddle);
      }
      for (AttackStep attackStep : _cacheParentBypassAdversaryInTheMiddleDefense) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.bypassAdversaryInTheMiddleDefense");
    }
  }

  public class AdversaryInTheMiddleDefenseBypassed extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAdversaryInTheMiddleDefenseBypassed;

    private Set<AttackStep> _cacheParentAdversaryInTheMiddleDefenseBypassed;

    public AdversaryInTheMiddleDefenseBypassed(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAdversaryInTheMiddleDefenseBypassed == null) {
        _cacheChildrenAdversaryInTheMiddleDefenseBypassed = new HashSet<>();
        _cacheChildrenAdversaryInTheMiddleDefenseBypassed.add(successfulAdversaryInTheMiddle);
      }
      for (AttackStep attackStep : _cacheChildrenAdversaryInTheMiddleDefenseBypassed) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAdversaryInTheMiddleDefenseBypassed == null) {
        _cacheParentAdversaryInTheMiddleDefenseBypassed = new HashSet<>();
        _cacheParentAdversaryInTheMiddleDefenseBypassed.add(bypassAdversaryInTheMiddleDefenseFromPhysicalAccess);
        _cacheParentAdversaryInTheMiddleDefenseBypassed.add(adversaryInTheMiddleDefense.disable);
        _cacheParentAdversaryInTheMiddleDefenseBypassed.add(bypassAdversaryInTheMiddleDefense);
      }
      for (AttackStep attackStep : _cacheParentAdversaryInTheMiddleDefenseBypassed) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.adversaryInTheMiddleDefenseBypassed");
    }
  }

  public class AttemptAdversaryInTheMiddle extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAttemptAdversaryInTheMiddle;

    private Set<AttackStep> _cacheParentAttemptAdversaryInTheMiddle;

    public AttemptAdversaryInTheMiddle(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAttemptAdversaryInTheMiddle == null) {
        _cacheChildrenAttemptAdversaryInTheMiddle = new HashSet<>();
        _cacheChildrenAttemptAdversaryInTheMiddle.add(successfulAdversaryInTheMiddle);
        _cacheChildrenAttemptAdversaryInTheMiddle.add(bypassAdversaryInTheMiddleDefense);
      }
      for (AttackStep attackStep : _cacheChildrenAttemptAdversaryInTheMiddle) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAttemptAdversaryInTheMiddle == null) {
        _cacheParentAttemptAdversaryInTheMiddle = new HashSet<>();
        _cacheParentAttemptAdversaryInTheMiddle.add(accessNetworkData);
      }
      for (AttackStep attackStep : _cacheParentAttemptAdversaryInTheMiddle) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.attemptAdversaryInTheMiddle");
    }
  }

  public class SuccessfulAdversaryInTheMiddle extends AttackStepMax {
    private Set<AttackStep> _cacheChildrenSuccessfulAdversaryInTheMiddle;

    private Set<AttackStep> _cacheParentSuccessfulAdversaryInTheMiddle;

    public SuccessfulAdversaryInTheMiddle(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenSuccessfulAdversaryInTheMiddle == null) {
        _cacheChildrenSuccessfulAdversaryInTheMiddle = new HashSet<>();
        _cacheChildrenSuccessfulAdversaryInTheMiddle.add(adversaryInTheMiddle);
      }
      for (AttackStep attackStep : _cacheChildrenSuccessfulAdversaryInTheMiddle) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentSuccessfulAdversaryInTheMiddle == null) {
        _cacheParentSuccessfulAdversaryInTheMiddle = new HashSet<>();
        _cacheParentSuccessfulAdversaryInTheMiddle.add(adversaryInTheMiddleDefenseBypassed);
        _cacheParentSuccessfulAdversaryInTheMiddle.add(attemptAdversaryInTheMiddle);
      }
      for (AttackStep attackStep : _cacheParentSuccessfulAdversaryInTheMiddle) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.successfulAdversaryInTheMiddle");
    }
  }

  public class AdversaryInTheMiddle extends AttackStepMin {
    private Set<AttackStep> _cacheChildrenAdversaryInTheMiddle;

    private Set<AttackStep> _cacheParentAdversaryInTheMiddle;

    public AdversaryInTheMiddle(String name) {
      super(name);
    }

    @Override
    public void updateChildren(Set<AttackStep> attackSteps) {
      if (_cacheChildrenAdversaryInTheMiddle == null) {
        _cacheChildrenAdversaryInTheMiddle = new HashSet<>();
        _cacheChildrenAdversaryInTheMiddle.add(eavesdrop);
        for (Data _0 : transitData) {
          _cacheChildrenAdversaryInTheMiddle.add(_0.attemptWrite);
        }
        for (Data _1 : transitData) {
          _cacheChildrenAdversaryInTheMiddle.add(_1.attemptApplicationRespondConnect);
        }
      }
      for (AttackStep attackStep : _cacheChildrenAdversaryInTheMiddle) {
        attackStep.updateTtc(this, ttc, attackSteps);
      }
    }

    @Override
    public void setExpectedParents() {
      super.setExpectedParents();
      if (_cacheParentAdversaryInTheMiddle == null) {
        _cacheParentAdversaryInTheMiddle = new HashSet<>();
        _cacheParentAdversaryInTheMiddle.add(successfulAdversaryInTheMiddle);
      }
      for (AttackStep attackStep : _cacheParentAdversaryInTheMiddle) {
        addExpectedParent(attackStep);
      }
    }

    @Override
    public double localTtc() {
      return ttcHashMap.get("Network.adversaryInTheMiddle");
    }
  }
}
