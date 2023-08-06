import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/core/models/employee';
import { EmployeeService } from '../../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  id: number;

  constructor(private employeeService: EmployeeService, private router : Router, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.activeRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(emp=>{
      this.employee = emp;
    })
  }

  onSubmit(){
    
    this.employeeService.updateEmployee(this.id, this.employee).subscribe(updatedEmployee => {
        console.log(updatedEmployee);
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
