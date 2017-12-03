/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  Image
} from 'react-native';
import {StackNavigator} from 'react-navigation';

import HomePage from './Components/HomePage';
import SignInP from './Components/SignInPatient';
import SignInD from './Components/SignInDoctor';
import TestFile from './Components/TestFile';
import DRegistration from './Components/DReg';
import PRegistration from './Components/PReg';
import PProfile from './Components/PatientProfile';
import DProfile from './Components/DoctorProfile';
import MakeAppt from './Components/MakeAppointment';
import CancelAppt from './Components/CancelAppointment';
import upload from './Components/UploadDoc';
import reset from './Components/ResetPass';
import MakeEvt from './Components/CreateEvent';
import CancelEvt from './Components/CancelEvent';
import viewApt from './Components/ViewAppts';
import viewDocs from './Components/ViewDocs';

const NavigationApp = StackNavigator(
  {
    Home: {screen: HomePage},
    SignInDoc: { screen: SignInD },
    SignInPat: { screen: SignInP },
    DocReg: { screen: DRegistration },
    PatReg: { screen: PRegistration },
    PPfile: { screen: PProfile },
    DPfile: { screen: DProfile },
    Appointment: { screen: MakeAppt },
    CancelApp: { screen: CancelAppt },
    up: { screen: upload},
    Rpass: { screen: reset},
    MEvent: { screen: MakeEvt },
    CEvent: { screen: CancelEvt },
    VAppt: { screen: viewApt},
    VDocs: { screen: viewDocs},
  }
);

export default class App extends Component<{}> {
  render() {
    return (
      <NavigationApp />
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
