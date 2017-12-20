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

import React from 'react';
import Button from 'material-ui/Button';
import Dialog, {
    DialogActions,
    DialogContent,
    DialogTitle,
} from 'material-ui/Dialog';
import Table, { TableBody, TableCell, TableHead, TableRow } from 'material-ui/Table';

class AlertDialog extends React.Component {
    handleClose = () => {
        this.props.onClose();
    };

    render() {
        let data = this.props.data;
        if (this.props.visible && data) {
            let policy = JSON.parse(data.policy);
            return (
                <div>
                    <Dialog
                        open={this.props.visible}
                        aria-labelledby="alert-dialog-title"
                        aria-describedby="alert-dialog-description"
                    >
                        <DialogTitle id="alert-dialog-title">{this.props.title}</DialogTitle>
                        <DialogContent>
                            <Table>
                                <TableHead>
                                    <TableRow>
                                        <TableCell>Property</TableCell>
                                        <TableCell>Value</TableCell>
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    <TableRow>
                                        <TableCell>Policy Name</TableCell>
                                        <TableCell>{data.name}</TableCell>
                                    </TableRow>

                                    <TableRow>
                                        <TableCell>Policy Type</TableCell>
                                        <TableCell>{data.type}</TableCell>
                                    </TableRow>

                                    {Object.keys(policy).map(key => {
                                        return (
                                            <TableRow key={key}>
                                                <TableCell>{key}</TableCell>
                                                <TableCell>{policy[key].toString()}</TableCell>
                                            </TableRow>
                                        )
                                    })}
                                </TableBody>
                            </Table>
                        </DialogContent>
                        <DialogActions>
                            <Button onClick={this.handleClose} color="primary" autoFocus>
                                Ok
                            </Button>
                        </DialogActions>
                    </Dialog>
                </div>
            );
        }
        return null;
    }
}

export default AlertDialog;