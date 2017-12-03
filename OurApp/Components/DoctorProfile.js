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

import MakeEvt from './CreateEvent';
import CancelEvt from './CancelEvent';
import viewApt from './ViewAppts';
import viewDocs from './ViewDocs';

const NavigationApp = StackNavigator(
  {
    MEvent: { screen: MakeEvt },
    CEvent: { screen: CancelEvt },
    VAppt: { screen: viewApt},
    VDocs: { screen: viewDocs},
  }
);

export default class DoctorProfile extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {text: ''};
  }
  _onPressButton()
  {
    Alert.alert('You tapped the button!')
  }
  static navigationOptions = { title: 'Doctors Profile Page', };
  render() {
    const { navigate } = this.props.navigation;
    return (
      <View style={styles.container}>
        <Text>
          Doctor Profile Page
        </Text>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('MEvent')}
            title="Create Event"
          />
        </View>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('CEvent')}
            title="Cancel Event"
          />
        </View>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('VAppt')}
            title="View Appoinments"
          />
        </View>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('VDocs')}
            title="View Documents"
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
            onPress={() => navigate('SignInDoc')}
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
  buttonContainer: {
    margin: 20,
    flexDirection: 'column',
    justifyContent: 'space-between'
  },
  nameInput:
  {
    height:40,
    width: 250,
    borderWidth: 1,
    borderColor: 'black',
    margin: 20,
  },
  alternativeLayoutButtonContainer:
  {
    margin: 30,
    flexDirection: 'row',
    justifyContent: 'space-between'
  }
});
