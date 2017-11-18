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

const NavigationApp = StackNavigator(
  {
    Home: {screen: HomePage},
    SignInDoc: { screen: SignInD },
    SignInPat: { screen: SignInP },
    DocReg: { screen: DRegistration },
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
