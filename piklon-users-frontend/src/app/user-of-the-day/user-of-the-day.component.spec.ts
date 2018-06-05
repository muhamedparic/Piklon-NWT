import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserOfTheDayComponent } from './user-of-the-day.component';

describe('UserOfTheDayComponent', () => {
  let component: UserOfTheDayComponent;
  let fixture: ComponentFixture<UserOfTheDayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserOfTheDayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserOfTheDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
