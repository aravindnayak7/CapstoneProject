import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustHistroyComponent } from './cust-histroy.component';

describe('CustHistroyComponent', () => {
  let component: CustHistroyComponent;
  let fixture: ComponentFixture<CustHistroyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CustHistroyComponent]
    });
    fixture = TestBed.createComponent(CustHistroyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
