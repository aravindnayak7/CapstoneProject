import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomserviceComponent } from './roomservice.component';

describe('RoomserviceComponent', () => {
  let component: RoomserviceComponent;
  let fixture: ComponentFixture<RoomserviceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RoomserviceComponent]
    });
    fixture = TestBed.createComponent(RoomserviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
