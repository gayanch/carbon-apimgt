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

import TextField from 'material-ui/TextField';
import Grid from 'material-ui/Grid';
import Paper from 'material-ui/Paper';

import React, {Component} from 'react';

class JSONPolicyFields extends Component {
    handleChange = name => event => {
        this.props.handleChangeChild(name, event.target.value);
    }

    render() {
        if (this.props.policy) {
            return (
                <Paper elevation={20}>
                    <br />
                    <Grid item xs={6} className="grid-item">
                        <TextField
                            id="name"
                            label="Policy Name"
                            defaultValue={this.props.policy.name}
                            className="text-field-half"
                            onChange={this.handleChange("name")}
                            helperText="An unique name for the policy"
                        />
                    </Grid>
                    <br />
                    <Grid item xs={6} className="grid-item">
                        <TextField
                            id="maxFieldCount"
                            label="Max Field Count"
                            defaultValue={this.props.policy.policy.maxFieldCount.toString()}
                            className="text-field-half"
                            onChange={this.handleChange("maxFieldCount")}
                            helperText="Maximum number of fields(keys) allowed in a JSON payload"
                        />
                    </Grid>
                    <br />
                    <Grid item xs={6} className="grid-item">
                        <TextField
                            id="maxFieldLength"
                            label="Max Field Length"
                            defaultValue={this.props.policy.policy.maxFieldLength.toString()}
                            className="text-field-half"
                            onChange={this.handleChange("maxFieldLength")}
                            helperText="Maximum length of a field(key) in a JSON payload"
                        />
                    </Grid>
                    <br />
                    <Grid item xs={6} className="grid-item">
                        <TextField
                            id="maxStringLength"
                            label="Max String Length"
                            defaultValue={this.props.policy.policy.maxStringLength.toString()}
                            className="text-field-half"
                            onChange={this.handleChange("maxStringLength")}
                            helperText="Maximum length of string values in a JSON payload"
                        />
                    </Grid>
                    <br />
                    <Grid item xs={6} className="grid-item">
                        <TextField
                            id="maxArrayElementCount"
                            label="Max Array Element Count"
                            defaultValue={this.props.policy.policy.maxArrayElementCount.toString()}
                            className="text-field-half"
                            onChange={this.handleChange("maxArrayElementCount")}
                            helperText="Maximum number of elements allowed on an array"
                        />
                    </Grid>
                    <br />
                    <Grid item xs={6} className="grid-item">
                        <TextField
                            id="maxDepth"
                            label="Max Depth"
                            defaultValue={this.props.policy.policy.maxDepth.toString()}
                            className="text-field-half"
                            onChange={this.handleChange("maxDepth")}
                            helperText="Maximum allowed depth for a JSON payload"
                        />
                    </Grid>
                    <br />
                </Paper>
            );
        } else {
            return (<h1>Please wait...</h1>);
        }
    }
}

export default JSONPolicyFields;
