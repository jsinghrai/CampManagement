import React, { Component } from 'react';
import {
  AppRegistry,
  Platform,
  StyleSheet,
  Text,
  View,
  Image,
  Button,
  Alert
} from 'react-native';
import {
  StackNavigator
} from 'react-navigation';

import SignInD from './SignInDoctor';
import SignInP from './SignInPatient';
import DRegistration from './DReg';


const NavigationApp = StackNavigator(
  {
    SignInDoc: { screen: SignInD },
    SignInPat: { screen: SignInP },
    DocReg: { screen: DRegistration },
  }
);

export default class HomePage extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {text: ''};
  }
   static navigationOptions = { title: 'Home', };
  _onPressButton()
  {
    Alert.alert('You tapped the button!')
  }
  render() {
    const { navigate } = this.props.navigation;
    return (
      <View style={styles.container}>
        <Text style={styles.inCenter}>
          Welcome to CMS!
        </Text>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('SignInDoc')}
            title="Doctor"
          />
        </View>
        <View style={styles.buttonContainer}>
          <Button
            onPress={() => navigate('SignInPat')}
            title="Patient"
          />
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  inCenter: {
    fontSize: 20,
    textAlign: 'center'
  },
  container: {
   flex: 1,
   justifyContent: 'center',
   alignItems: 'center',
   backgroundColor: '#F5FCFF',
   //backgroundColor: '#F5FCFF'
  },
  buttonContainer: {
    margin: 30,
    flexDirection: 'column',
    justifyContent: 'space-between'
  },
  alternativeLayoutButtonContainer: {
    margin: 20,
    flexDirection: 'row',
    justifyContent: 'space-between'
  }
});
