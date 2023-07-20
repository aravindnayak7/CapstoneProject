import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeLogoutComponent } from './home-logout.component';

describe('HomeLogoutComponent', () => {
  let component: HomeLogoutComponent;
  let fixture: ComponentFixture<HomeLogoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HomeLogoutComponent]
    });
    fixture = TestBed.createComponent(HomeLogoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
