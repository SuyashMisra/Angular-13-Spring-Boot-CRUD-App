import {AfterViewInit, Component } from '@angular/core';
import { Employee } from '../../../core/models/employee';
import { EmployeeService } from '../../services/employee.service';
import { MatDialog } from '@angular/material/dialog';
import { DeleteEmployeeDialogComponent } from '../delete-employee-dialog/delete-employee-dialog.component';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements AfterViewInit  {

  displayedColumns: string[] = ['firstName','lastName','emailId','actions'];
  data: Employee[] = [];

  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;


  constructor(public dialog: MatDialog, private employeeService: EmployeeService) {}

  ngAfterViewInit() {

    this.loadEmployeeList();
   
  }

  private loadEmployeeList(){
    this.isLoadingResults = true;
    this.employeeService.getEmployeeList().subscribe(data =>{
      this.isLoadingResults=false;
      if (data===null) {
        this.data = []
      }
      else{
        this.data = data;
      }
      this.resultsLength = data.length;
    });
  }


  public openDialog(employeeId: number): void {
    
    let dialogRef = this.dialog.open(DeleteEmployeeDialogComponent, {
      width: '300px',
      height: '180px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result){
        this.deleteEmployee(employeeId);
      }
    });
  }

  deleteEmployee(employeeId: number){
    this.isLoadingResults = true;
    this.employeeService.deleteEmployee(employeeId).subscribe(data=>{
      this.loadEmployeeList();
    });
  }

}

