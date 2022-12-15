import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { solid } from '@fortawesome/fontawesome-svg-core/import.macro'

function Table(props) {
  return (
    <div className="TableContainer">
      <table className="Table">
        <thead>
          <tr>
            <td>ID</td>
            <td>Employee Name</td>
            <td>Department</td>
            <td>Salary</td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Jerry Thomas</td>
            <td>Back-End</td>
            <td>15000</td>
            <td className="TableIcons">
              <FontAwesomeIcon icon={solid('pencil')} />
              <FontAwesomeIcon icon={solid('trash-alt')} />
            </td>
          </tr>

          <tr>
            <td colSpan={5}><h2>No Employee Found</h2></td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default Table;
