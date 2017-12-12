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
  ToastAndroid
} from 'react-native';
import {
  StackNavigator
} from 'react-navigation';

import PRegistration from './PReg';
import PProfile from './PatientProfile';
import MakeAppt from './MakeAppointment';
import CancelAppt from './CancelAppointment';
import upload from './UploadDoc';
import reset from './ResetPass';

const NavigationApp = StackNavigator(
  {
    PatReg: { screen: PRegistration },
    PPfile: { screen: PProfile },
    Appointment: { screen: MakeAppt },
    CancelApp: { screen: CancelAppt },
    up: { screen: upload},
    Rpass: { screen: reset},
  }
);

var SQLite = require('react-native-sqlite-storage')
var db = SQLite.openDatabase({name: 'test.db', createFromLocation: '~CMS.db'}, this.openCB, this.errorCB)

export default class SignInPatient extends Component<{}> {
  constructor(props) {
    super(props);
    this.state = {userid: '',
      passd: '',
      testing: ''
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

  onPressButton=(navigate) => {
    if(this.state.userid == '')
    {
      msg = "Please Input your Username";
      ToastAndroid.show(msg, ToastAndroid.SHORT);
    }
    else if(this.state.passd == '')
    {
      msg = "Please Input your Password";
      ToastAndroid.show(msg, ToastAndroid.SHORT);
    }
    else {
      db.transaction((tx) => {
        tx.executeSql('SELECT * FROM Credentials WHERE C_UserID=? AND C_passHash=?', [this.state.userid, this.state.passd], (tx, results) => {
          var len = results.rows.length;
          if(len > 0){
            ToastAndroid.show("Successful Sign In for "+ this.state.userid, ToastAndroid.SHORT);
            this.setState({testing: "successful"});
          } else {
            ToastAndroid.show("Sign In failed for "+ this.state.userid, ToastAndroid.SHORT);
            return;
          }
          navigate('PPfile');
        });
      });
    }
  }

  static navigationOptions = { title: 'Patients', };
  render() {
    const { navigate } = this.props.navigation;
    return (
      <View style = {styles.container}>
        <Text style={styles.inCenter}>
          Please Sign In or Register!
        </Text>
        <TextInput style={styles.nameInput}
          placeholder = 'Enter your username/Email'
          onChangeText={(userid) => this.setState({userid})}
        />
        <TextInput style={styles.nameInput}
          placeholder = 'Enter your Password'
          onChangeText={(passd) => this.setState({passd})}
        />
        <View style={styles.alternativeLayoutButtonContainer}>
          <Button
            onPress={() => this.onPressButton(navigate)}
            //onPress={()=> navigate('PPfile')}
            title="Sign In"
          />
        </View>
        <View style={styles.alternativeLayoutButtonContainer}>
          <Button
            onPress={() => navigate('PatReg')}
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
