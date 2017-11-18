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
  TextInput,
  ScrollView
} from 'react-native';
import {StackNavigator} from 'react-navigation';

export default class DReg extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {text: ''};
  }
  static navigationOptions = { title: 'Doctor Registration', };
  render() {
    const { navigate } = this.props.navigation;
    return (
      <ScrollView contentContainerStyle={styles.contentContainer}>
        <View style={styles.container}>
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your User Name'>
          </TextInput>
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Password'>
          </TextInput>
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Name (ex. First Last)'>
          </TextInput>
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Hospitals Name'>
          </TextInput>
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Speciality'>
          </TextInput>
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Email'>
          </TextInput>
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Phone number'>
          </TextInput>
          <View>
            <Button
              onPress={() => navigate('SignInDoc')}
              title="Register"
            />
          </View>
        </View>
       </ScrollView>
    );
  }
}

const styles = StyleSheet.create({
   contentContainer: {
     paddingVertical: 20
   },
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
