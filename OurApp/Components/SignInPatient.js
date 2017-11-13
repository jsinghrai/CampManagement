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

export default class SignIn extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {text: ''};
  }
  _onPressButton()
  {
    Alert.alert('You tapped the button!')
  }
  render() {
    return (
      <View>
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
    margin: 20
  },
  alternativeLayoutButtonContainer:
  {
    margin: 20,
    flexDirection: 'row',
    justifyContent: 'space-between'
  }
});
