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

var SQLite = require('react-native-sqlite-storage')
var db = SQLite.openDatabase({name: 'test.db', createFromLocation: '~CMS.db'})

export default class CreateEvent extends Component<{}> {
  constructor(props)
  {
    super(props)
    this.state = {
      testing: "",
    };

    db.transaction((tx) => {
      tx.executeSql('SELECT * FROM Patient WHERE P_Name=?', ['Jaspal'], (tx, results) => {
        var len = results.rows.length;
        if(len > 0){
          var row = results.rows.item(0);
          this.setState({testing: row.P_Email});
        }
      });
    });
  }
  _onPressButton()
  {
    Alert.alert('You tapped the button!')
  }
  static navigationOptions = { title: 'Create Event', };
  render() {
    const { navigate } = this.props.navigation;
    return (
      <View style={styles.container}>
          <Text>SQLite Example</Text>
          <Text>{'Jaspal \'s email is ' + this.state.testing}</Text>
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
    margin: 30,
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
