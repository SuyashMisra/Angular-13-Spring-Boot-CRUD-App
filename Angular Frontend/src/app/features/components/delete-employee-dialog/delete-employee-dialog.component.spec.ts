import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteEmployeeDialogComponent } from './delete-employee-dialog.component';

describe('DeleteEmployeeDialogComponent', () => {
  let component: DeleteEmployeeDialogComponent;
  let fixture: ComponentFixture<DeleteEmployeeDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteEmployeeDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteEmployeeDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
