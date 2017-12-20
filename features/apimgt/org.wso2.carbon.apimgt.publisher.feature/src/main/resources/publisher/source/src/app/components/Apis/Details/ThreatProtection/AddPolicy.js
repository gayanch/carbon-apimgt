/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import React, {Component} from 'react'

import {Link} from 'react-router-dom'
import AppBar from 'material-ui/AppBar';
import Toolbar from 'material-ui/Toolbar';;
import IconButton from 'material-ui/IconButton';
import Button from 'material-ui/Button';
import MenuIcon from 'material-ui-icons/Menu';
import Typography from 'material-ui/Typography';
import Divider from 'material-ui/Divider';
import Grid from 'material-ui/Grid';
import Paper from 'material-ui/Paper';
import Input, { InputLabel } from 'material-ui/Input';
import Select from 'material-ui/Select';
import { MenuItem } from 'material-ui/Menu';

import API from '../../../../data/api'
import Message from '../../../Shared/Message'
import AlertDialog from './AlertDialog'

class AddPolicy extends Component {
    state = {
        selectedPolicy : {uuid: '', name: 'Select', policy: '', type: ''},
        viewPolicyDialog: false,
        policies: []
    };

    constructor(props) {
        super(props);
        let api = new API();
        let promisedApi = api.get(this.props.match.params.api_uuid);
        promisedApi.then(response => {
           this.setState({currentApi: response.obj});
        });
    }

    componentDidMount() {
        let api = new API();
        let promisedPolicies = api.getThreatProtectionPolicies();
        promisedPolicies.then(response => {
            this.setState({policies: response.obj.list});
        });
    }

    handlePolicyAdd() {
        let policy = this.state.selectedPolicy;
        if (policy.uuid === '' || policy.name === '') {
            this.msg.error("Please select a policy");
            return;
        }

        if (this.state.currentApi) {
            let currentApi = this.state.currentApi;
            let api = new API();
            let promisedPolicyAdd = api.addThreatProtectionPolicyToApi(currentApi.id, this.state.selectedPolicy.uuid);
            promisedPolicyAdd.then(response => {
                if (response.status === 200) {
                    this.msg.info("Threat protection policy added successfully.");
                } else {
                    this.msg.error("Failed to add threat protection policy.");
                }
            });
        }
    }

    handleChange = name => event => {
        let policyId = event.target.value;
        let api = new API();
        let promisedPolicy = api.getThreatProtectionPolicy(policyId);
        promisedPolicy.then(response => {
            this.setState({selectedPolicy: response.obj});
        });
    }

    toggleViewPolicy() {
        this.setState({viewPolicyDialog: !this.state.viewPolicyDialog})
    }

    render() {
        return (
            <div>
                <AppBar position="static" >
                    <Toolbar style={{minHeight:'30px'}}>
                        <IconButton color="contrast" aria-label="Menu">
                            <MenuIcon />
                        </IconButton>
                        <Link to={"/apis/" + this.props.match.params.api_uuid + "/threat-protection"}>
                            <Button color="contrast">Go Back</Button>
                        </Link>
                    </Toolbar>
                </AppBar>
                <Message ref={a => this.msg = a}/>
                <AlertDialog
                    data={this.state.selectedPolicy}
                    visible={this.state.viewPolicyDialog}
                    onClose={this.toggleViewPolicy.bind(this)}
                    title="View Policy"
                />
                <Paper>
                    <Grid container className="root" direction="column">
                        <Grid item xs={12} className="grid-item">
                            <Typography className="page-title" type="display1" gutterBottom>
                                Add Threat Protection Policy
                            </Typography>
                        </Grid>
                        <br/>
                        <br/>
                        <Paper>
                            <Grid item xs={12} className="grid-item">
                                <InputLabel htmlFor="selectedPolicy">Policy</InputLabel>
                                &nbsp;&nbsp;
                                <Select
                                    value={this.state.selectedPolicy.uuid}
                                    onChange={this.handleChange("selectedPolicy")}
                                    input={<Input name="selectedPolicy" id="selectedPolicy" />}
                                >
                                    {this.state.policies.map(n => {
                                        return (
                                            <MenuItem key={n.uuid} value={n.uuid}>{n.name}</MenuItem>
                                        );
                                    })};
                                </Select>
                            </Grid>
                            <br/>
                            <br/>
                            <br/>
                            <Grid item xs={12} className="grid-item">
                                <Divider />
                                <div >
                                    <Button raised color="primary" onClick = {
                                        () => this.handlePolicyAdd()}>
                                        Add
                                    </Button>
                                    &nbsp;
                                    <Button raised onClick={() => this.toggleViewPolicy()}
                                            disabled={this.state.selectedPolicy.uuid === ''}>
                                        View Selected Policy
                                    </Button>
                                    &nbsp;
                                    <Link to={"/apis/" + this.props.match.params.api_uuid + "/threat-protection"}>
                                        <Button raised>Cancel</Button>
                                    </Link>
                                </div>
                            </Grid>
                        </Paper>
                    </Grid>
                </Paper>
            </div>
        );
    }
}

export default AddPolicy
