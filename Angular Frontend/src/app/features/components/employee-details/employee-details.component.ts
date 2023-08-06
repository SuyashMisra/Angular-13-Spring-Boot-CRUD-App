import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from 'src/app/core/models/employee';
import { EmployeeService } from '../../services/employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent{

  displayedColumns: string[] = ['key', 'value'];
  employee: Employee;
  id: number;
  isLoadingResults = true;
  data: {key: string, value: string}[] = [];

  constructor(private activeRoute: ActivatedRoute, private employeeService: EmployeeService) { }

  ngAfterViewInit(): void {
    this.id = this.activeRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(data=>{
      this.employee = data;
      this.data.push(
        {
          key:'First Name',
          value: this.employee.firstName
        },
        {
          key:'Last Name',
          value: this.employee.lastName
        },
        {
          key:'Email',
          value: this.employee.emailId
        }
      )
      this.isLoadingResults=false;
    })
  }

}
