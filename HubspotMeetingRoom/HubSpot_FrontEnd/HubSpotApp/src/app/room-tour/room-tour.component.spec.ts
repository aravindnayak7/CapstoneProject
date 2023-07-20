import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomTourComponent } from './room-tour.component';

describe('RoomTourComponent', () => {
  let component: RoomTourComponent;
  let fixture: ComponentFixture<RoomTourComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RoomTourComponent]
    });
    fixture = TestBed.createComponent(RoomTourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
