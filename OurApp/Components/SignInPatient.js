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

export default class SignInPatient extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {text: ''};
  }
  _onPressButton()
  {
    Alert.alert('You tapped the button!')
  }
  static navigationOptions = { title: 'Patients', };
  render() {
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
            onPress={ this._onPressButton}
            title="Sign In"
          />
        </View>
        <View style={styles.alternativeLayoutButtonContainer}>
          <Button
            onPress={ this._onPressButton}
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
