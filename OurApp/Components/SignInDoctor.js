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

import DRegistration from './DReg';
import DProfile from './DoctorProfile';
import MakeEvt from './CreateEvent';
import CancelEvt from './CancelEvent';
import viewApt from './ViewAppts';
import viewDocs from './ViewDocs';

const NavigationApp = StackNavigator(
  {
    DocReg: { screen: DRegistration },
    DPfile: { screen: DProfile },
    MEvent: { screen: MakeEvt },
    CEvent: { screen: CancelEvt },
    VAppt: { screen: viewApt},
    VDocs: { screen: viewDocs},
  }
);

export default class SignInDoctor extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {text: ''};
  }
  _onPressButton()
  {
    Alert.alert('You tapped the button!')
  }
  static navigationOptions = { title: 'Doctors', };
  render() {
    const { navigate } = this.props.navigation;
    return (
      <View style = {styles.container}>
        <Text style={styles.inCenter}>
          Please Sign In or Register!
        </Text>
        <TextInput style={styles.nameInput}
          placeholder = 'Enter your username/Email'>
        </TextInput>
        <TextInput style={styles.nameInput}
          placeholder = 'Enter your Password'>
        </TextInput>
        <View style={styles.alternativeLayoutButtonContainer}>
          <Button
            onPress={()=> navigate('DPfile')}
            title="Sign In"
          />
        </View>
        <View style={styles.alternativeLayoutButtonContainer}>
          <Button
            onPress={() => navigate('DocReg')}
            title="Register"
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
  alternativeLayoutButtonContainer:
  {
    margin: 30,
    flexDirection: 'row',
    justifyContent: 'space-between'
  }
});
