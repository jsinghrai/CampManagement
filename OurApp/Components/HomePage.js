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
import ViewContainer from './ViewContainer'
import SignInD from './SignInDoctor';
import SignInP from './SignInPatient';

export default class HomePage extends Component<{}> {
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
      <View style={styles.container}>
        <Text style={styles.inCenter}>
          Welcome to CMS!
        </Text>
        <View style={styles.buttonContainer}>
          <Button
            onPress={ this._onPressButton}
            title="Doctor"
          />
        </View>
        <View style={styles.buttonContainer}>
          <Button
            onPress= {this._onPressButton}
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
   //backgroundColor: '#F5FCFF'
  },
  buttonContainer: {
    margin: 20
  },
  alternativeLayoutButtonContainer: {
    margin: 20,
    flexDirection: 'row',
    justifyContent: 'space-between'
  }
});
