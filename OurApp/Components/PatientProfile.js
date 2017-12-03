import React, { Component } from 'react';
import {
  AppRegistry,
  Platform,
  StyleSheet,
  Text,
  View,
  Image,
  Button,
  Alert,
  TextInput
} from 'react-native';
import {
  StackNavigator
} from 'react-navigation';

import MakeAppt from './MakeAppointment';
import CancelAppt from './CancelAppointment';
import upload from './UploadDoc';
import reset from './ResetPass';

const NavigationApp = StackNavigator(
  {
    Appointment: { screen: MakeAppt },
    CancelApp: { screen: CancelAppt },
    up: { screen: upload},
    Rpass: { screen: reset},
  }
);

export default class PatientProfile extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {text: ''};
  }
  _onPressButton()
  {
    Alert.alert('You tapped the button!')
  }
  static navigationOptions = { title: 'Patient Profile Page', };
  render() {
    const { navigate } = this.props.navigation;
    return (
      <View style={styles.container}>
        <Text>
          Patient Profile Page
        </Text>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('Appointment')}
            title="Make Appointment"
          />
        </View>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('CancelApp')}
            title="Cancel Appointment"
          />
        </View>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('up')}
            title="Upload Documents"
          />
        </View>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('Rpass')}
            title="Reset Password"
          />
        </View>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('SignInPat')}
            title="Log Out"
          />
        </View>
      </View>
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
  inCenter: {
    fontSize: 20,
    textAlign: 'center'
  },
  nameInput:
  {
    height:40,
    width: 250,
    borderWidth: 1,
    borderColor: 'black',
    margin: 20,
  },
  buttonContainer: {
    margin: 20,
    flexDirection: 'column',
    justifyContent: 'space-between'
  },
  alternativeLayoutButtonContainer:
  {
    margin: 30,
    flexDirection: 'row',
    justifyContent: 'space-between'
  }
});
