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
  ScrollView,
  ToastAndroid
} from 'react-native';
import {StackNavigator} from 'react-navigation';

var SQLite = require('react-native-sqlite-storage')
var db = SQLite.openDatabase({name: 'test.db', createFromLocation: '~CMS.db'}, this.openCB, this.errorCB)

export default class PReg extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {username: '',
      passd: '',
      name: '',
      age: '',
      address: '',
      email: '',
      pnumber: '',
      salt: 'testing'
    };
  }
  errorCB(err)
  {
    ToastAndroid.show("SQL Error: " + err, ToastAndroid.SHORT);
  }
  sucessCB()
  {
    ToastAndroid.show("SQL executed ok", ToastAndroid.SHORT);
  }
  openCB()
  {
    console.log("SQL executed fine");
  }

  static navigationOptions = { title: 'Patient Registration', };

  onPressButton=(navigate) => {
    //ToastAndroid.show("Registering: " + this.state.username , ToastAndroid.SHORT);
    //var sql = 'INSERT INTO Patient VALUES(\''+this.state.username+'\',\''+this.state.username+'\',\''+this.state.name+'\',\''+this.state.address+'\',\''+this.state.pnumber+'\',\''+this.state.email+'\',\''+this.state.age+'\'';
    //ToastAndroid.show(sql, ToastAndroid.SHORT);
    db.transaction((tx) => {
      //tx.executeSql('SELECT * FROM Patient WHERE P_Name=?', ['Jaspal'], (tx, results) => {
      //var sql = 'INSERT INTO Patient VALUES(\''+this.state.username+'\',\''+this.state.username+'\',\''+this.state.name+'\',\''+this.state.address+'\',\''+this.state.pnumber+'\',\''+this.state.email+'\',\''+this.state.age+'\')';
      //ToastAndroid.show(sql, ToastAndroid.SHORT);
      tx.executeSql('INSERT INTO Patient VALUES(?,?,?,?,?,?,?)', [this.state.username, this.state.username, this.state.name, this.state.address, this.state.pnumber, this.state.email, this.state.age], (tx, results) => {
        //ToastAndroid.show(sql, ToastAndroid.SHORT);
        ToastAndroid.show('resultSet.insertId: ' + resultSet.insertId, ToastAndroid.SHORT);
        ToastAndroid.show('resultSet.rowsAffected: ' + resultSet.rowsAffected, ToastAndroid.SHORT);
      });
    });
    db.transaction((tx) => {
      tx.executeSql('INSERT INTO Credentials VALUES(?,?,?,?)', [this.state.username, this.state.passd, this.state.salt, 'P'], (tx, results) => {
        ToastAndroid.show('resultSet.insertId: ' + resultSet.insertId, ToastAndroid.SHORT);
        ToastAndroid.show('resultSet.rowsAffected: ' + resultSet.rowsAffected, ToastAndroid.SHORT);
      });
    });
      //<Text>{'Result type is  ' + typeof tt}</Text>
    ToastAndroid.show("Registering "+ this.state.username, ToastAndroid.SHORT);
    navigate('SignInPat')
  }
  render() {
    const { navigate } = this.props.navigation;
    return (
      <ScrollView contentContainerStyle={styles.contentContainer}>
        <View style={styles.container}>
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your User Name'
            onChangeText={(username) => this.setState({username})}
          />
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Password'
            onChangeText={(passd) => this.setState({passd})}
          />
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Name (ex. First Last)'
            onChangeText={(name) => this.setState({name})}
          />
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Age'
            onChangeText={(age) => this.setState({age})}
          />
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Address'
            onChangeText={(address) => this.setState({address})}
          />
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Email'
            onChangeText={(email) => this.setState({email})}
          />
          <TextInput style={styles.nameInput}
            placeholder = 'Enter your Phone number'
            onChangeText={(pnumber) => this.setState({pnumber})}
          />
          <View>
            <Button
              onPress={() => this.onPressButton(navigate)}
              //onPress={() => navigate('SignInPat')}
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
