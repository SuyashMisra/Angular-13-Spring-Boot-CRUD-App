import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-delete-employee-dialog',
  templateUrl: './delete-employee-dialog.component.html',
  styleUrls: ['./delete-employee-dialog.component.css']
})
export class DeleteEmployeeDialogComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DeleteEmployeeDialogComponent>) { }

  ngOnInit(): void {
  }

  confirmDelete(){
    this.dialogRef.close(true);
  }

  closeDialog() {
    this.dialogRef.close(false);
  }

}
