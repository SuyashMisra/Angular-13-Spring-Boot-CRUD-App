import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/core/models/employee';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    
    this.employeeService.createEmployee(this.employee).subscribe(addedEmployee => {
        console.log(addedEmployee);
        this.router.navigate(['/employees']);
      },
      error => console.log(error)
    );
  }

  isFormValid(): boolean{
    if(this.employee.firstName && this.employee.lastName && this.employee.emailId){
      return true;
    }
    return false;
  }

}
