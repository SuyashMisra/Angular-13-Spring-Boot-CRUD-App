import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Employee } from '../../core/models/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl: string = `${environment.baseUrl}/employees`;

  constructor(private httpClient: HttpClient) { }

  getEmployeeList() : Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseUrl);
  }
  
  getEmployeeById(id: number) : Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Employee) : Observable<Employee>{
    return this.httpClient.post<Employee>(this.baseUrl, employee);
  }

  updateEmployee(id: number, employee: Employee) : Observable<Employee>{
    return this.httpClient.put<Employee>(`${this.baseUrl}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<boolean>{
    return this.httpClient.delete<boolean>(`${this.baseUrl}/${id}`);
  }


}
