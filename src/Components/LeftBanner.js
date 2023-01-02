import React from "react";

function LeftBanner({ mode, 
                    firstName, 
                    lastName, 
                    department, 
                    salary, 
                    filter, 
                    sort, 
                    handleResetState, 
                    handleChange,
                    handleAdd,
                    handleFilter, 
                    handleClearFilter}) {
  const departments = ["Front-end", "Back-end", "Full-stack", "Testing"];

  return (
    <div className="LeftBanner">
      <div className="AsideDiv">
        <div className="AsideTitle">
          <span>
            {mode ? "Add" : "Update"} 
          </span>
          <button className="ClearButton" 
                onClick={handleResetState}>Clear</button>
        </div>
        <hr />
        <form onSubmit={handleAdd}>
          <input type="text" 
                placeholder="First Name" 
                className="InputFields" 
                name="firstName" 
                value={firstName}
                onChange={handleChange}/>
          <input type="text" 
                placeholder="Last Name" 
                className="InputFields" 
                name="lastName" 
                value={lastName}
                onChange={handleChange}/>
          <select name="department"
                value={department}
                onChange={handleChange}>
            <option value="">--Select Department--</option>
            {departments.map((dept) => (
              <option key={dept} 
                    value={dept}>
                {dept}
              </option>
            ))}
          </select>
          <input type="number" 
                placeholder="Salary per month" 
                className="InputFields" 
                name="salary" 
                value={salary}
                onChange={handleChange}/>
          <button className="AddButton" 
                type="submit">
            {mode ? "Add" : "Update"}
          </button>
        </form>
      </div>

      <div className="AsideDiv">
        <div className="AsideTitle">
          <span>Filter & Sort</span>
          <button className="ClearButton"
                onClick={handleClearFilter}>Clear</button>
        </div>
        <hr />
        <form onSubmit={handleFilter}>
          <select value={filter}>
            <option value="">--No filter--</option>
            {departments.map((dept) => (
              <option key={dept} 
                    value={dept}>
                {dept}
              </option>
            ))}
          </select>
          <select value={sort}>
            <option value="">--No sorting--</option>
            <option value="asc">Low to High</option>
            <option value="desc">High to Low</option>
          </select>
          <button className="AddButton" type="submit">Filter</button>
        </form>
      </div>
    </div>
  );
}

export default LeftBanner;
